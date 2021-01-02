package com.nytimesarticles.data


object Urls {

    // base API url
    const val baseUrl = "https://api.nytimes.com/"

    //get list of most popular articles
    const val getMostPopularArticles = "svc/mostpopular/v2/viewed/{period}.json"


}

object ApiParams {
    object Query {
        const val api_key = "api-key"
        const val language = "language"
        const val page = "page"

    }

}