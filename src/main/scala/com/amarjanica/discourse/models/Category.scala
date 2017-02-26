package com.amarjanica.discourse.models

import com.amarjanica.discourse.util.SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
case class CategoryContainer(category: Category)

@JsonIgnoreProperties(ignoreUnknown = true)
case class CategoryListContainer(category_list: CategoryList)

@JsonIgnoreProperties(ignoreUnknown = true)
case class CategoryList(categories: List[Category])

@JsonIgnoreProperties(ignoreUnknown = true)
case class Category(
  id: Int,
  name: String,
  color: String,
  @JsonProperty("text_color")
  textColor: String,
  description:  Option[String] = None,
  permissions: Option[Map[String, Int]] = None,
  @JsonProperty("parent_category_id")
  parentCategoryId: Option[Int] = None,
  slug: Option[String] = None,
  @JsonProperty("auto_close_hours")
  autoCloseHours: Option[String] = None,
  @JsonProperty("auto_close_based_on_last_post")
  autoCloseBasedOnLastPost: Option[Boolean] = None,
  position: Option[Int] = None,
  @JsonProperty("email_in")
  emailIn: Option[Boolean],
  @JsonProperty("email_in_allow_strangers")
  emailInAllowStrangers: Option[Boolean] = None,
  @JsonProperty("logo_url")
  logoUrl: Option[String] = None,
  @JsonProperty("allow_badges")
  allowBadges: Option[Boolean] = None,
  @JsonProperty("topic_template")
  topicTemplate: Option[String] = None
) extends SerializableAsJson

@JsonIgnoreProperties(ignoreUnknown = true)
case class CreateCategory(
  name: String,
  color: String,
  @JsonProperty("text_color")
  textColor: String,
  description:  Option[String] = None,
  permissions: Option[Map[String, Int]] = None,
  @JsonProperty("parent_category_id")
  parentCategoryId: Option[Int] = None
) extends SerializableAsJson
