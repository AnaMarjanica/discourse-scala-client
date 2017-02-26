package com.amarjanica.discourse.models

import java.time.OffsetDateTime

import com.amarjanica.discourse.util.SerializableAsJson

case class UserDetail(
  badges: List[Badge],
  user: User
) extends SerializableAsJson

case class User(
  id: Int,
  username: String,
  @JsonProperty("uploaded_avatar_id")
  uploadedAvatarId: Option[Int] = None,
  @JsonProperty("avatar_template")
  avatarTemplate: Option[String],
  name: Option[String],
  email: Option[String],
  @JsonProperty("last_posted_at")
  lastPostedAt: Option[OffsetDateTime] = None,
  @JsonProperty("last_seen_at")
  lastSeenAt: Option[OffsetDateTime] = None,
  @JsonProperty("bio_cooked")
  bioCooked: Option[String] = None,
  @JsonProperty("created_at")
  createdAt: OffsetDateTime,
  @JsonProperty("can_edit")
  canEdit: Boolean,
  @JsonProperty("can_edit_username")
  canEditUsername: Boolean,
  @JsonProperty("can_edit_email")
  canEditEmail: Boolean,
  @JsonProperty("can_edit_name")
  canEditName: Boolean,
  @JsonProperty("can_send_private_message_to_user")
  canSendPrivateMessageToUser: Boolean,
  @JsonProperty("bio_excerpt")
  bioExcerpt: String,
  @JsonProperty("trust_level")
  trustLevel: Int,
  moderator: Boolean,
  admin: Boolean,
  title: Option[String] = None,
  @JsonProperty("badge_count")
  badgeCount: Int,
  @JsonProperty("has_title_badges")
  hasTitleBadges: Boolean,
  @JsonProperty("number_of_deleted_posts")
  numberOfDeletedPosts: Int,
  @JsonProperty("number_of_flagged_posts")
  numberOfFlaggedPosts: Int,
  @JsonProperty("number_of_flags_given")
  numberOfFlagsGiven: Int,
  @JsonProperty("number_of_suspensions")
  numberOfSuspensions: Int,
  locale: Option[String] = None, // Some("en")
  @JsonProperty("email_digests")
  emailDigests: Boolean,
  @JsonProperty("email_private_messages")
  emailPrivateMessages: Boolean,
  @JsonProperty("email_direct")
  emailDirect: Boolean,
  @JsonProperty("email_always")
  emailAlways: Boolean,
  @JsonProperty("digest_after_days")
  digestAfterDays: Int,
  @JsonProperty("mailing_list_mode")
  mailingListMode: Boolean,
  @JsonProperty("auto_track_topics_after_msecs")
  autoTrackTopicsAfterMsecs: Long,
  @JsonProperty("new_topic_duration_minutes")
  newTopicDurationMinutes: Int,
  @JsonProperty("external_links_in_new_tab")
  externalLinksInNewTab: Boolean,
  @JsonProperty("dynamic_favicon")
  dynamicFavicon: Boolean,
  @JsonProperty("enable_quoting")
  enableQuoting: Boolean,
  @JsonProperty("muted_category_ids")
  mutedCategoryIds: List[Int],
  @JsonProperty("tracked_category_ids")
  trackedCategoryIds: List[Int],
  @JsonProperty("watched_category_ids")
  watchedCategoryIds: List[Int],
  @JsonProperty("private_messages_stats")
  privateMessagesStats: Map[String, Int],
  @JsonProperty("disable_jump_reply")
  disableJumpReply: Boolean,
  @JsonProperty("gravatar_avatar_upload_id")
  gravatarAvatarUploadId: Option[Int] = None,
  @JsonProperty("custom_avatar_upload_id")
  custom_avatar_upload_id: Option[Int] = None,
  groups: List[Group]
) extends BasicUser(id, username, avatarTemplate)

case class UpdateEmail(
  email: String,
  @JsonProperty("api_key")
  apiKey: String,
  @JsonProperty("api_username")
  apiUsername: String
) extends SerializableAsJson

case class UpdateUsername(
  @JsonProperty("new_username")
  newUsername: String,
  @JsonProperty("api_key")
  apiKey: String
) extends SerializableAsJson

case class UpdateTrustLevel(
  @JsonProperty("user_id")
  userId: Int,
  level: Int
) extends SerializableAsJson

case class SuspendUser(
  duration: Int, // days
  reason: String
) extends SerializableAsJson

case class CreateUser(
  name: String,
  username: String,
  password: String,
  active: Boolean,
  email: String,
  staged: Boolean = false // flag for fake user
) extends SerializableAsJson

// TODO: similar to DiscourseStatusMEssage
case class CreateUserResponse(
  success: Boolean,
  active: Option[Boolean],
  message: String,
  @JsonProperty("user_id")
  userId: Int
)
