package com.amarjanica.discourse.api

import com.amarjanica.discourse.DiscourseApiClient
import com.amarjanica.discourse.api.models.SearchResponse

trait WithSearch {
  self: DiscourseApiClient =>

  def searchQuery(term: String): SearchResponse = searchQuery(term, Map.empty)

  /** Returns search results that match the specified term.
    *
    * @param term search term
    * @param opts optional query parameters e.g type_filter, include_blurbs, blurb_length
    * @return
    */
  def searchQuery(term: String, opts: Map[String, String]): SearchResponse = {
    get(
      "/search/query",
      opts + ("terms" -> term)
    ).as[SearchResponse]
  }
}
