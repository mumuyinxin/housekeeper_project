package cn.lijie.dijiuci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		TextView tv_welcome = (TextView) findViewById(R.id.tv_welcome);
		
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		tv_welcome.setText(name+"»¶Ó­Äã£¡");
		
	}
}
