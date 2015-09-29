package com.algonquincollege.vard0020.loginexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button forgotPassword = (Button) findViewById(R.id.forgotPasswordButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext( ), "Login button :: onClick( )", Toast.LENGTH_SHORT ).show( );

                EditText userNameText = (EditText) findViewById(R.id.username);
                EditText passwordText = (EditText) findViewById(R.id.password);
                CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox);
                String password = passwordText.getText().toString();
                String userName = userNameText.getText().toString();


                //VALIDATE the userName
                //the user must provide a username (!)

                //checking for emptiness
                if(userName.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Invalid username", Toast.LENGTH_LONG).show();
                    userNameText.setError("Please enter your username");
                    userNameText.requestFocus();
                    return;
                }

                 //checking the length
                if(userName.length()!=8)
                {
                    Toast.makeText(getApplicationContext(), "Invalid username", Toast.LENGTH_LONG).show();
                    userNameText.setError("The username must be exactly 8 characters in length");
                    userNameText.requestFocus();
                    return;
                }

                //checking for uppercase
                if((Character.isUpperCase(userName.charAt(0)) && Character.isUpperCase(userName.charAt(1))))
                {
                    Toast.makeText(getApplicationContext(), "Invalid username", Toast.LENGTH_LONG).show();
                    userNameText.setError("The first 2 characters of username must only be lowercase alphabetic (a-z)");
                    userNameText.requestFocus();
                    return;
                }

                //checking for letters, digits ans ascii
                if((Character.isLetter(userName.charAt(0))) && (Character.isLetter(userName.charAt(1))))
                {

                }


                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid username", Toast.LENGTH_LONG).show();
                    userNameText.setError("The first 2 characters of username must only be lower-case alphabetic (a-z)");
                    userNameText.requestFocus();
                    return;
                }

                //VALIDATE the password
                //the user must provide a password (!)
                if(password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_LONG).show();
                    passwordText.setError("Please enter your password");
                    passwordText.requestFocus();
                    return;

                }

                //checking password length
                if(passwordText.length()<5)
                {
                    Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_LONG).show();
                    passwordText.setError("Password must be at least 5 characters in length:");
                    passwordText.requestFocus();
                    return;
                }

                //check the checkbox state
                if(checkbox.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "Remember me? - True :: OnClick( )", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Remember me? - False :: OnClick( )", Toast.LENGTH_LONG).show();
                }

                //SUCCESS1! All user input is validated
                Toast.makeText( getApplicationContext( ), "Login successful. Username and password are valid :: OnClick()", Toast.LENGTH_LONG ).show( );

            }
        });


        forgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext( ), "Forgot My Password? :: onClick( )", Toast.LENGTH_SHORT ).show( );
            }

        });











    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
