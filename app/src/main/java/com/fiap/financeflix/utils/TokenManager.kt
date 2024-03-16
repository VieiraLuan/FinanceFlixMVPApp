import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {
	private val sharedPreferences: SharedPreferences = context.getSharedPreferences("TokenManager", Context.MODE_PRIVATE)
	private val tokenKey = "token"


	fun saveToken(token: String) {
		val editor = sharedPreferences.edit()
		editor.putString(tokenKey, token)
		editor.apply()
	}

	fun getToken(): String? {
		return sharedPreferences.getString(tokenKey, null)
	}

	fun hasToken(): Boolean {
		return sharedPreferences.contains(tokenKey)
	}

	fun deleteToken() {
		val editor = sharedPreferences.edit()
		editor.remove(tokenKey)
		editor.apply()
	}
}
