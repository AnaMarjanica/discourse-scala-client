package com.amarjanica.discourse
package api

import models._

class SearchApi(client: BaseDiscourseClient){

  /** Returns search results that match the specified term.
    *
    * @param term search term
    * @param opts optional query parameters e.g type_filter, include_blurbs, blurb_length
    * @return
    */
  def searchQuery(term: String, opts: Map[String, String] = Map.empty): SearchResponse = {
    client.get(
      "/search/query",
      opts + ("terms" -> term)
    ).as[SearchResponse]
  }
}
