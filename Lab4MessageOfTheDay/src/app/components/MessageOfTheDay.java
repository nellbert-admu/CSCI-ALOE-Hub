package app.components;

import app.entities.User;
import app.repositories.UserRepository;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.Map;

@Component
public class MessageOfTheDay {

    private final UserRepository userRepository;
    private final TwilioComponent twilioComponent;
    private final RetrofitService retrofitService;

    @Autowired
    public MessageOfTheDay(UserRepository userRepository, TwilioComponent twilioComponent) {
        this.userRepository = userRepository;
        this.twilioComponent = twilioComponent;

        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:9999")  // Replace with App 1's base URL
                .build();

        this.retrofitService = retrofit.create(RetrofitService.class);
    }

    public TwilioReply sendMessageOfTheDay(Long userId, String category) {
        // Find the user by primary key (ID)
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        try {
            // Retrieve message from App 1 using Retrofit
            Call<ResponseBody> call = retrofitService.getMessageByCategory(category);
            Response<ResponseBody> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                // Parse the response manually
                String messageText = parseMessage(response.body().string());

                // Create a personalized message
                String personalizedMessage = "Hello " + user.getName() + ", " + messageText;

                // Send the message via TwilioComponent
                return twilioComponent.sendSMS(user.getCellphoneNumber(), personalizedMessage);
            } else {
                throw new RuntimeException("Failed to retrieve message from App 1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new TwilioReply(null, "Exception during message retrieval: " + e.getMessage());
        }
    }

    // Helper method to parse the message from JSON
    private String parseMessage(String jsonResponse) throws IOException {
        // Assume response format is: {"message": "Your message text here"}
        int start = jsonResponse.indexOf(":\"") + 2;
        int end = jsonResponse.lastIndexOf("\"");
        return jsonResponse.substring(start, end);
    }
}