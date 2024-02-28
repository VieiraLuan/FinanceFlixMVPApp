package com.fiap.financeflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fiap.financeflix.ui.theme.FinanceFlixTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			FinanceFlixTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {

					//Processo para realizar merge

					//1 - clonar projeto para uma pasta no pc
					//2 - Mudar para branch de cada um nome remoto
					//3 - Fazer o que tem que ser feito
					//4 - Ao finalizar, fazer commit e push
					//5 - Em seguida fazer merge para master levando as ultimas configs da sua branch

					//

				}
			}
		}
	}
}



