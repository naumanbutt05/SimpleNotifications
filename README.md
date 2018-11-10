# SimpleNotifications
Generate Notifications with a call of a single function

# Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

allprojects 

    {
       repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
# Step 2. Add the dependency

	implementation 'com.github.naumanbutt05:SimpleNotifications:0.1.1'
	
# Step 3. Code

	SimpleNotifications.generateNotification(Context,int channel id,String channel id,String channel name,String title,String message,
                int large icon,int small icon,ClassName);

# Sample Java Code Example

	SimpleNotifications.generateNotification(this,123,"ChannelID","ChannelName","title","message",
                R.drawable.large_icon, R.drawable.small_icon,MainActivity.class);

	

