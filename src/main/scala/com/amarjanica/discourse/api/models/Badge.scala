package com.amarjanica.discourse.api.models

import com.amarjanica.discourse.util.SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
case class BadgeContainer(badges: Array[Badge])

@JsonIgnoreProperties(ignoreUnknown = true)
case class Badge(
  id: Int,
  name: String,
  description: Option[String],
  @JsonProperty("grant_count")
  grantCount: Int,
  @JsonProperty("allow_title")
  allowTitle: Boolean,
  @JsonProperty("multiple_grant")
  multipleGrant: Boolean,
  icon: String,
  image: Option[String] = None,
  listable: Boolean,
  enabled: Boolean,
  @JsonProperty("badge_grouping_id")
  badgeGroupingId: Int,
  system: Boolean,
  slug: String,
  @JsonProperty("badge_type_id")
  badgeTypeId: Int,
  @JsonProperty("long_description")
  longDescription: Option[String] = None
) extends SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
case class CreateBadge(
  name: String,
  @JsonProperty("badge_type_id")
  badgeTypeId: Int, // (gold: 1, bronze: 3, silver: 2)
  description: Option[String] = None,
  @JsonProperty("allow_title")
  allowTitle: Option[Boolean] = None,
  @JsonProperty("multiple_grant")
  multipleGrant: Option[Boolean] = None,
  icon: Option[String] = None,
  listable: Option[Boolean] = None,
  @JsonProperty("target_posts")
  targetPosts: Option[String] = None,
  query: Option[String] = None,
  enabled: Option[Boolean] = None,
  @JsonProperty("auto_revoke")
  autoRevoke: Option[Boolean] = None,
  @JsonProperty("badge_grouping_id")
  badgeGroupingId: Option[Int] = None,
  @JsonProperty("show_posts")
  showPosts: Option[Boolean] = None,
  image: Option[String] = None,
  @JsonProperty("long_description")
  longDescription: Option[String] = None
) extends SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
case class GrantBadge(
  @JsonProperty("badge_id")
  badgeId: Int,
  username: String,
  reason: String
) extends SerializableAsJson


