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
package aykuttasil.com.modernapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import aykuttasil.com.modernapp.data.local.dao.LocationDao
import aykuttasil.com.modernapp.data.local.dao.UserDao
import aykuttasil.com.modernapp.data.local.entity.LocationEntity
import aykuttasil.com.modernapp.data.local.entity.UserEntity
import aykuttasil.com.modernapp.util.converter.RoomTypeConverter

@Database(
        entities = [
            (UserEntity::class),
            (LocationEntity::class)
        ],
        version = 1)
@TypeConverters(RoomTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    abstract fun getLocationDao(): LocationDao
}