package com.example.jetsnack.services

import android.app.IntentService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetsnack.R
import com.example.jetsnack.ui.navigation.MainDestinations
import com.example.jetsnack.ui.snackdetail.SnackDetail

private var notificationId: Int = 0
class OrderIntentService : IntentService("OrderIntentService") {
	
	@Deprecated("Deprecated in Java")
	override fun onHandleIntent(intent: Intent?) {
		val total = intent?.getIntExtra("total", 0) ?: 5
		notificationId++
		handleOrders(this, total)
	}
	
	private fun handleOrders(context: Context, total: Int) {
		createNotificationChannel(context, "checkout", "Checkout Notifications")
		showNotification(context, "checkout", "Jum! Jum!", notificationId, "Gracias por tu compra. Tu pedido está siendo pocesado y en breve podrás disfrutar de una maravillosa experiencia gastronomica 🤤")
	}
	
	private fun createNotificationChannel(context: Context, channelId: String, channelName: String) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			val channel = NotificationChannel(
				channelId,
				channelName,
				NotificationManager.IMPORTANCE_DEFAULT
			).apply {
				description = "This channel is used for order notifications."
				enableVibration(true)
				vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
				val audioAttributes = AudioAttributes.Builder()
					.setUsage(AudioAttributes.USAGE_NOTIFICATION)
					.build()
				setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), audioAttributes)
			}
			val notificationManager: NotificationManager =
				context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
			notificationManager.createNotificationChannel(channel)
		}
	}
	
	private fun showNotification(context: Context, channelId: String, title: String, id: Int, content: String) {
		val builder = NotificationCompat.Builder(context, channelId)
			.setSmallIcon(R.drawable.ic_launcher_foreground)
			.setContentTitle(title)
			.setContentText(content)
			.setPriority(NotificationCompat.PRIORITY_DEFAULT)
			.setStyle(NotificationCompat.BigTextStyle().bigText(content))
		
		val notificationManager: NotificationManager =
			context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
		notificationManager.notify(id, builder.build())
	}
}

