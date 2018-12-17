package cn.lijie.dijiuci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		final EditText et_register_name = (EditText) findViewById(R.id.et_register_name);
		final EditText password = (EditText) findViewById(R.id.password);
		final EditText confirm_password = (EditText) findViewById(R.id.confirm_password);
		
		Button bt_register = (Button) findViewById(R.id.bt_register);
		
		bt_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = et_register_name.getText().toString().trim();
				String password1 = password.getText().toString().trim();
				String password2 = confirm_password.getText().toString().trim();
					
				if(password1.isEmpty() &&name.isEmpty()&&password2.isEmpty()){
					Toast.makeText(RegisterActivity.this, "用户名、密码、确认密码不能为空!",0).show();
					return;
				}
				if(!(password1.equals(password2))){
					Toast.makeText(RegisterActivity.this, "密码和确认密码不一致!",0).show();
					return;
				}
				Intent data = new Intent();
				data.putExtra("name", name);
				setResult(RESULT_OK, data );
				data.putExtra("password", password1);
				setResult(RESULT_OK, data );
		
				finish();
			}
		});
	}
}
