package githubuser.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Jakana Kiwanuka.
 */
public class NetworkConnectivity {
    /**
     * Network Utility class.
     */
    Context context;

    /**
     * Constructor of the network Connectivity class.
     * @param context context data
     */
    public NetworkConnectivity(Context context) {
        this.context = context;
    }

    /**
     * Boolean to check if wifi is connected or not.
     * @return networkInfo
     */
    public boolean isWifiConnected() {
        ConnectivityManager connMan = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMan.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
