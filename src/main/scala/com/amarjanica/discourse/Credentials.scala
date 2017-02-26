package com.amarjanica.discourse

import com.amarjanica.discourse.util.{HasParameters, HasQueryParameters}

/** Used for authorizing discourse requests
 *
 * @param api_username - same as username you use to login to discourse
 * @param api_key - key is listed in /admin/api (very long string). Recommended api_key is not a master api key,
 *                  but a key generated specifically for your admin username (api_username),
 *                  located in http://www.rockbazaar.com/forum/admin/users/{id}/{username},
 *                  below Permissions title.
 */
case class Credentials(
  api_username: String,
  api_key: String
) extends HasParameters with HasQueryParameters
