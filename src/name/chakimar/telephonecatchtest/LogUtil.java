package name.chakimar.telephonecatchtest;

import java.util.Iterator;
import java.util.Set;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LogUtil {

	/**
	 * Intentのデータを出力
	 * @param data
	 */
	public static void dump(Intent data) {
		if (data != null) {
			Bundle bundle = data.getExtras();
			if (bundle != null) {
				StringBuilder sb = new StringBuilder();
				Set<String> keySet = bundle.keySet();
				Iterator<String> it = keySet.iterator();
				while (it.hasNext()) {
					String key = it.next();
					sb.append("[" + key +":" +bundle.get(key) + "]");
				}
				//電話番号等の情報が入ってます。
				Log.d("TelephoneCatchTest", sb.toString());
			}
		}
	}
}
