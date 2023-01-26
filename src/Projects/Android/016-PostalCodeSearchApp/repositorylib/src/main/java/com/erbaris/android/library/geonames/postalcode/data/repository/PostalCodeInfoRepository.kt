package com.erbaris.android.library.geonames.postalcode.data.repository

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.erbaris.android.library.geonames.postalcode.data.entity.PostalCodeInfo
import org.csystem.util.datetime.DateTimeConvertUtil
import java.util.*
import javax.inject.Inject

private const val CREATE_POSTAL_CODE_INFO = """
    CREATE TABLE postal_code_info (
        code INTEGER,
        query_date_time INTEGER not null,
        CONSTRAINT postal_code_info_PK PRIMARY KEY(code)
    );
"""

private const val CODE = "code"
private const val QUERY_DATE_TIME = "query_date_time"
private const val TABLE_NAME = "postal_code_info"

class PostalCodeInfoRepository @Inject constructor() : IPostalCodeInfoRepository {
    @Inject
    lateinit var db: SQLiteDatabase

    private fun createPostalCodeInfo(cursor: Cursor) : PostalCodeInfo
    {
        val code = cursor.getLong(0)
        val queryDateTime = cursor.getLong(1);

        return PostalCodeInfo(code, DateTimeConvertUtil.toLocalDateTime(queryDateTime))
    }

    override fun findByCode(code: Int) : PostalCodeInfo? {
        val projection = arrayOf(CODE, QUERY_DATE_TIME)
        var cursor: Cursor? = null
        var postalCodeInfo: PostalCodeInfo? = null
        
        try {
            cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)
            if (cursor != null && cursor.moveToFirst())
                postalCodeInfo = createPostalCodeInfo(cursor)
        }
        finally {
            cursor?.close()
        }

        return postalCodeInfo
    }
    override fun <S : PostalCodeInfo?> save(postalCodeInfo: S) : S
    {
        TODO("Not yet implemented")
    }

    //Not implemented methods
    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun delete(entity: PostalCodeInfo?) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<PostalCodeInfo>?) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Int>?) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int?) {
        TODO("Not yet implemented")
    }

    override fun existsById(id: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<PostalCodeInfo> {
        TODO("Not yet implemented")
    }

    override fun findAllById(id: MutableIterable<Int>?): MutableIterable<PostalCodeInfo> {
        TODO("Not yet implemented")
    }

    override fun findById(code: Int): Optional<PostalCodeInfo>
    {
        TODO("Not yet implemented")
    }



    override fun <S : PostalCodeInfo?> saveAll(entities: MutableIterable<S>?): MutableIterable<S> {
        TODO("Not yet implemented")
    }


}