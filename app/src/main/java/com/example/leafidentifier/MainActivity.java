package com.example.leafidentifier;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    ImageView leafImageView; //imageView for the image selected on main screen
    Button identifyButton; //Button on main screen
    byte[] imageByteArray; //byte array of the image from selected leaf
    Intent intent;
    Bitmap bitmap;
    String HOST = "192.168.1.4";
    int PORT = 5050;

    class MyTask extends AsyncTask<Void, Void, String> {
        ProgressDialog progDailog; //the please wait.. box shown while fetching result
        @Override
        protected void onPreExecute() { //method executed automatically on pre execution of this async task
            super.onPreExecute();
            progDailog = new ProgressDialog(MainActivity.this);
            progDailog.setMessage("Please Wait...");
            progDailog.setIndeterminate(false);
            progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progDailog.setCancelable(true);
            progDailog.show();
        }

        @Override
        protected String doInBackground(Void... voids) { //main task which does main work of the async task
            try {
                changeBitmapToByteArray(); // changes the bitmap to byte array and stores in instance variable imageByteArray
                Socket photoSocket = new Socket(HOST, PORT); // creates new socket
                DataOutputStream dos = new DataOutputStream(photoSocket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(photoSocket.getInputStream()));

                int size = imageByteArray.length;
                dos.writeInt(size); //sends size of the image to server
                System.out.println("size written");
                dos.write(imageByteArray); //sends the image to the server
                System.out.println("image sent");
                String result = reader.readLine(); // reads the result sent by the server
                System.out.println(result);
                dos.close();
                dos.flush();
                photoSocket.close();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return "connection error";
            }
        }

        @Override
        protected void onPostExecute(String leafName) { // method executed automatically when async task is finished
            super.onPostExecute(leafName);
            progDailog.dismiss(); // dismiss the please wait... dialog box
            facilitateChoosingImage(); //changes screen state to facilitate choosing image again
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class); // start new intent to show result on different screen
            intent.putExtra("leafName", leafName); //sends the answer received from the server to the new screen
            intent.putExtra("image", imageByteArray); //sends the image selected by the user to the new screen
            startActivity(intent);
        }
    }

        public void mainButtonClicked(View view) { //executes when the button on main screen is clciked
            if (view.getTag().toString().equals("0")) { //check the tag tag:0 = choose image tag:1 = identify leaf
                intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);

            } else {
                MyTask myTask = new MyTask();
                myTask.execute();
            }
        }

        void changeBitmapToByteArray() { //change bitmap to byte array and save it in the class variable imageByteArray which is then used to send to server and send to the result screen
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            imageByteArray = stream.toByteArray();
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //when new intent of choosing image is shown
            super.onActivityResult(requestCode, resultCode, data);
            Uri selectedImage = null;
            try {
                selectedImage = data.getData(); //gets the selected image
            }catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (requestCode == 1 && resultCode == RESULT_OK) {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage); // gets bitmap of the selected image from gallery
                    leafImageView.setImageBitmap(bitmap); //sets image on the imageView on screen
                    leafImageView.setVisibility(View.VISIBLE); //makes imageView visible
                    facilitateIdentification(); //changes screen components and state to facilitate identification of image
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            leafImageView = findViewById(R.id.leafImageView);
            identifyButton = findViewById(R.id.identifyButton);
        }

        void facilitateChoosingImage() {
            identifyButton.setText("choose image");
            identifyButton.setTag("0");
        }

        void facilitateIdentification() {
            identifyButton.setText("identify");
            identifyButton.setTag("1");
        }
}

