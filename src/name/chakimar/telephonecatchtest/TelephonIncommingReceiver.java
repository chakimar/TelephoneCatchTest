package name.chakimar.telephonecatchtest;

import java.lang.reflect.Method;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.android.internal.telephony.ITelephony;

public class TelephonIncommingReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent data) {

		LogUtil.dump(data);
		
		Toast.makeText(context, "着信をキャンセル", Toast.LENGTH_SHORT).show();
		TelephonyManager telephony = (TelephonyManager) 
		context.getSystemService(Context.TELEPHONY_SERVICE);  
		try {
			Class<?> c = Class.forName(telephony.getClass().getName());
			Method m = c.getDeclaredMethod("getITelephony");
			m.setAccessible(true);
			ITelephony telephonyService = (ITelephony) m.invoke(telephony);
			//呼び出し音を消す。
			telephonyService.silenceRinger();
			//着信を切る
			telephonyService.endCall();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
