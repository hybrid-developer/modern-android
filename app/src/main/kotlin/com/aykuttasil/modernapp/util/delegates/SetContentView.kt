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
package com.aykuttasil.modernapp.util.delegates

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class SetContentView<in R : Activity, out DB : ViewDataBinding>(@LayoutRes private val layoutRes: Int) :
  ReadOnlyProperty<R, DB> {

  private var value: DB? = null

  override fun getValue(thisRef: R, property: KProperty<*>): DB {
    value = value ?: DataBindingUtil.setContentView(thisRef, layoutRes)
    return value!!
  }
}

fun <T : Activity, R : ViewDataBinding> contentView(@LayoutRes layoutRes: Int): SetContentView<T, R> {
  return SetContentView(layoutRes)
}
