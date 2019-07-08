/**
 * Designed and developed by Aykut Asil (@aykuttasil)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package aykuttasil.com.modernapp.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import aykuttasil.com.modernapp.R
import aykuttasil.com.modernapp.di.ViewModelFactory
import aykuttasil.com.modernapp.ui.common.BaseActivity
import com.aykutasil.modernapp.util.edit
import javax.inject.Inject

class MainActivity : BaseActivity() {

  @Inject
  lateinit var viewModelFactory: ViewModelFactory

  @Inject
  lateinit var sharedPreference: SharedPreferences

  private val viewModel by viewModels<MainViewModel> { viewModelFactory }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    viewModel.forTest()

    sharedPreference.edit {
      it.putString("test", "test")
    }
  }
}
