package name.chakimar.telephonecatchtest;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TelephoneOutgoingReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent data) {
		
		LogUtil.dump(data);

		Intent intent = new Intent(context, MainActivity.class);
		PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent, 0);
		try {
			pIntent.send();
		} catch (CanceledException e) {
			e.printStackTrace();
		}

		Toast.makeText(context, "発信をキャンセル", Toast.LENGTH_LONG).show();
		//発信をキャンセルする。
		setResultData(null);
	}
	
}
