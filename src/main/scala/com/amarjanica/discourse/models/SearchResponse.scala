package com.amarjanica.discourse.models

import java.time.OffsetDateTime

case class SearchResponse (
  topics: List[SearchResponseTopic],
  posts: List[SearchResponsePost],
  users: List[SearchResponseUsers],
  categories: List[SearchResponseCategories],
  @JsonProperty("grouped_search_result")
  groupedSearchResult: GroupedSearchResult
)
class SearchResponseTopic(
  id: Long,
  title: String,
  @JsonProperty("fancy_title")
  fancyTitle: String,
  slug: String,
  @JsonProperty("posts_count")
  postsCount: Int,
  @JsonProperty("reply_count")
  replyCount: Int,
  @JsonProperty("highest_post_number")
  highestPostNumber: Int,
  @JsonProperty("image_url")
  imageUrl: String,
  @JsonProperty("created_at")
  createdAt: OffsetDateTime,
  @JsonProperty("last_posted_at")
  lastPostedAt: OffsetDateTime,
//  bumped: Boolean,
//  @JsonProperty("bumped_at")
//  bumpedAt: OffsetDateTime,
//  unseen: Boolean,
  pinned: Boolean,
  unpinned: Boolean,
  visible: Boolean,
  closed: Boolean,
  archived: Boolean,
  bookmarked: Boolean,
  liked: Option[Boolean] = None,
  views: Int,
  @JsonProperty("like_count")
  likeCount: Int,
//  @JsonProperty("has_summary")
//  hasSummary: Boolean,
//  archetype: String,
  @JsonProperty("last_poster_username")
  lastPosterUsername: Option[String] = None,
  @JsonProperty("category_id")
  categoryId: Option[Int] = None,
  @JsonProperty("pinned_globally")
  pinnedGlobally: Boolean,
  tags: List[String]
//  @JsonProperty("has_accepted_answer")
//  hasAcceptedAnswer: Boolean
)

case class SearchResponsePost(
  id: Long,
  name: Option[String] = None,
  username: String,
  @JsonProperty("avatar_template")
  avatarTemplate: Option[String] = None,
  @JsonProperty("created_at")
  createdAt: Option[String] = None,
  cooked: String,
  @JsonProperty("like_count")
  likeCount: Int,
  blurb: String,
  @JsonProperty("post_number")
  postNumber: Int,
  @JsonProperty("topic_id")
  topicId: Long
)

/*TODO: map other fields*/
case class SearchResponseUsers(
  id: Long
)

/*TODO: map other fields*/
case class SearchResponseCategories(
  id: Long
)

case class GroupedSearchResult(
  @JsonProperty("more_posts")
  morePosts: Option[Boolean] = None,
  @JsonProperty("more_users")
  moreUsers: Option[Boolean] = None,
  @JsonProperty("more_categories")
  moreCategories: Option[Boolean] = None,
  @JsonProperty("post_ids")
  postIds: List[Long],
  @JsonProperty("user_ids")
  userIds: List[Long],
  @JsonProperty("category_ids")
  categoryIds: List[Long]
)
