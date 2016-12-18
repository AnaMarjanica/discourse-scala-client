package com.amarjanica.discourse.api

import com.amarjanica.discourse.DiscourseApiClient
import com.amarjanica.discourse.api.models._

trait WithCategories { self: DiscourseApiClient =>

  def createCategory(createCategory: CreateCategory): Category =
    post("/categories", createCategory).as[Category]

  def updateCategory(category: Category): Category =
    put(s"/categories/${category.id}", category).as[Category]

  def listCategories(opts: Map[String, String]): Array[Category] =
    get("/categories.json", opts).as[CategoryListContainer].category_list.categories

  def getCategory(id: Int): Category =
    get(s"/c/$id/show.json").as[CategoryContainer].category
}
