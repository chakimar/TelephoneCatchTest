package name.chakimar.telephonecatchtest;

import java.util.Iterator;
import java.util.Set;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class LogUtil {

	/**
	 * Intent�̃f�[�^���o��
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
				//�d�b�ԍ����̏�񂪓����Ă܂��B
				Log.d("TelephoneCatchTest", sb.toString());
			}
		}
	}
}
