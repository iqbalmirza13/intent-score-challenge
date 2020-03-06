package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String HOME_KEY = "home";
    public static final String AWAY_KEY = "away";
    public static final int HOME_REQUEST_CODE =1;
    public static final int AWAY_REQUEST_CODE=2;
    private static String home_image;
    private static String away_image;
    private static final String HOME_IMAGE = home_image;
    private static final String AWAY_IMAGE = away_image;
    private EditText homeInput;
    private EditText awayInput;
    private ImageView homeImage;
    private ImageView awayImage;
    private String homeURL;
    private String awayURL;
    private Uri imageUri1;
    private Uri imageUri2;
    private Bitmap bitmap1;
    private Bitmap bitmap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeInput = findViewById(R.id.home_team);
        awayInput = findViewById(R.id.away_team);
        homeImage = findViewById(R.id.home_logo);
        awayImage = findViewById(R.id.away_logo);
        //TODO

        //Fitur Main Activity

        //1. Validasi Input Home Team

        //2. Validasi Input Away Team

        //3. Ganti Logo Home Team

        //4. Ganti Logo Away Team

        //5. Next Button Pindah Ke MatchActivity

    }
    public void handleMatch(View view){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.PNG, 50,baos);
        bitmap2.compress(Bitmap.CompressFormat.PNG, 50,baos2);

        Intent intent = new Intent(this,MatchActivity.class);
        String home = homeInput.getText().toString();
        String away = awayInput.getText().toString();
        intent.putExtra(HOME_KEY, home);
        intent.putExtra(AWAY_KEY, away);
        intent.putExtra("homeLogo",baos.toByteArray());
        intent.putExtra("awayLogo",baos2.toByteArray());

        startActivity(intent);
    }



    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            return;
        }

        if(requestCode == 1){
            if (data != null) {
                try {
                    imageUri1 = data.getData();
                    bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri1);
                    homeImage.setImageBitmap(bitmap1);
                }catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                }
            }
        }

        else if(requestCode == 2){
            if (data != null) {
                try {
                    imageUri2 = data.getData();
                    bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri2);
                    awayImage.setImageBitmap(bitmap2);
                }catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

//    public void clickButton_next(View view){
//        String Home = homeInput.getText().toString();
//        String Away = awayInput.getText().toString();
//
//        if (!(Home).equals("") && !(Away).equals("")){
//            if (bitmap1 != null && bitmap2 != null) {
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
//                bitmap1.compress(Bitmap.CompressFormat.PNG, 50,baos);
//                bitmap2.compress(Bitmap.CompressFormat.PNG, 50,baos2);
//                Intent intent = new Intent(this,MatchActivity.class);
//                intent.putExtra(HOME_KEY,Home);
//                intent.putExtra(AWAY_KEY,Away);
//                intent.putExtra(AWAY_IMAGE,imageUri1.toString());
//                intent.putExtra(HOME_IMAGE,imageUri2.toString());
//                intent.putExtra("homeLogo",baos.toByteArray());
//                intent.putExtra("awayLogo",baos2.toByteArray());
//                startActivity(intent);
//            }else {
//                Toast.makeText(this, "Lengkapi data terlebih dahulu", Toast.LENGTH_SHORT).show();
//            }
//        }else{
//            Toast.makeText(this, "Lengkapi data terlebih dahulu", Toast.LENGTH_SHORT).show();
//        }
//    }

    public void clickhandleChangeImageHome(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    public void clickhandleChangeImageAway(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 2);
            }
        }

