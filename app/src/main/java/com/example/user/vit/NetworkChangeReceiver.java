//package com.example.user.vit;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.util.Log;
//import android.widget.Toast;
//
//public class NetworkChangeReceiver extends BroadcastReceiver {
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        final ConnectivityManager connMgr = (ConnectivityManager) context
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo activeNetwork = connMgr.getActiveNetworkInfo();
//        if(activeNetwork!=null){
//            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE
//                    || activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
//                Toast.makeText(context, activeNetwork.getTypeName(), Toast.LENGTH_SHORT).show();
//                Log.d("Something", "cscscc");
//            }
//        }
//    }
//}
