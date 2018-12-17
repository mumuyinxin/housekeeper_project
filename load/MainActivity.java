package cn.lijie.dijiuci;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
    protected static final int REGISTER = 0;
	private String name;
	private EditText et_main_password;
	private TextView et_main_name;
	private String passwords;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et_main_name = (EditText) findViewById(R.id.et_main_name);
        et_main_password= (EditText) findViewById(R.id.et_main_password);
        Button bt_main_login = (Button) findViewById(R.id.bt_main_login);
        TextView tv_main_new = (TextView) findViewById(R.id.tv_main_new);
        
        bt_main_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String input_name = et_main_name.getText().toString().trim();
				String name = et_main_name.getText().toString().trim();
				String password = et_main_password.getText().toString().trim();
				
				if(password.isEmpty()){
		        	Toast.makeText(MainActivity.this, "用户名、密码不能为空!",0).show();
		        	return;
		        }
		        if(!(password.equals(passwords))){
		        	Toast.makeText(MainActivity.this, "用户名、密码有误!",0).show();
		        	return;
		        }
		        
					Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
					intent.putExtra("name", input_name);
					startActivity(intent);
					finish();
			}
		});
      
        
        tv_main_new.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
				startActivityForResult(intent, REGISTER);

				}
		});
    }
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REGISTER) {
			if (resultCode == RESULT_OK) {
				name = data.getStringExtra("name");
				et_main_name.setText(name);
				passwords = data.getStringExtra("password");
			}
		}
	}
}
