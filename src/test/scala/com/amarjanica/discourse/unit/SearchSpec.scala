package com.amarjanica.discourse.unit

import org.specs2.Specification

class SearchSpec extends Specification with BaseSpec {

  def is = s2"""
      When searching for some term, then search result should be returned $testSearchQuery
  """

  def testSearchQuery = {
    val discourseClient = client("search.json")

    val result = discourseClient.searchQuery("test", Map.empty[String, String])

    (result.posts should beEmpty) and
    (result.topics should beEmpty) and
    (result.categories should beEmpty) and
    (result.users should beEmpty)
  }
}
