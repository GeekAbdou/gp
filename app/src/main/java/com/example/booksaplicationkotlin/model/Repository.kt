package com.example.booksaplicationkotlin.model


import com.example.booksaplicationkotlin.db.LocalSource
import com.example.booksaplicationkotlin.model.BookResponse
import com.example.booksaplicationkotlin.network.RemoteSource
import com.example.booksaplicationkotlin.model.RepositoryInterface
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

private const val TAG = "Repository"
class Repository(private var remoteSource: RemoteSource,private var localSource: LocalSource): RepositoryInterface {

    companion object{
        private var instance:Repository? = null

        fun getInstance(remoteSource: RemoteSource , localSource: LocalSource):Repository{
            return instance?: synchronized(this){
                val temp = Repository(remoteSource,localSource)
                instance = temp
                temp
            }

        }
    }

    override suspend fun getBooks(token: String): Response<BookResponse>? {
        return remoteSource.getBooks("Bearer $token")
    }

    override suspend fun getSpecificBook(query: String, filter: String): Response<BookResponse>? {
        return remoteSource.getSpecificBook(query,filter)
    }

    override suspend fun rateBook(token: String, id: Int, rate: Float): Response<RateResponse>? {
        return remoteSource.rateBook("Bearer $token",id,rate)
    }
    override fun getBooksFromDatabase(): Flow<List<Record>> {
        return localSource.getBooksFromDatabase()
    }

    override suspend fun insertBooks(books: List<Record>) {
        localSource.insertBooks(books)
    }

    override fun searchByName(data: String): Flow<List<Record>> {
        return localSource.searchByName(data)
    }

    override fun searchByAuthor(data: String): Flow<List<Record>> {
        return localSource.searchByAuthor(data)
    }

    override fun searchByField(data: String): Flow<List<Record>> {
        return localSource.searchByField(data)
    }

    override fun searchByYear(data: String): Flow<List<Record>> {
        return localSource.searchByYear(data)
    }

    override fun searchProjectByName(data: String): Flow<List<GradProject>> {
        TODO("Not yet implemented")
    }

    override fun searchProjectByAuthor(data: String): Flow<List<GradProject>> {
        TODO("Not yet implemented")
    }

    override fun searchProjectByField(data: String): Flow<List<GradProject>> {
        TODO("Not yet implemented")
    }

    override fun searchProjectByYear(data: String): Flow<List<GradProject>> {
        TODO("Not yet implemented")
    }


}