package com.stupidamigo.sabasicapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{

	MediaPlayer oursong;
	@Override
	protected void onCreate(Bundle Amit) {
		// TODO Auto-generated method stub
		super.onCreate(Amit);
		setContentView(R.layout.splash);
		oursong = MediaPlayer.create(Splash.this, R.raw.music1);
		oursong.start();
		Thread timer = new Thread(){
			public void run() {
				try{
					sleep(3000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openMainActivity = new Intent("com.stupidamigo.sabasicapp.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		oursong.release();
		finish();
	}

}
