package bwkha.jupiter.retailkart;

import android.app.Application;

import com.onesignal.OneSignal;

public class retailkart extends Application {
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
