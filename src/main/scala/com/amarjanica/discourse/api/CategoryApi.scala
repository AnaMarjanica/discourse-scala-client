package com.amarjanica.discourse
package api

import models._

class CategoryApi(client: BaseDiscourseClient){

  def create(createCategory: CreateCategory): Category =
    client.post("/categories", createCategory).as[Category]

  def update(category: Category): Category =
    client.put(s"/categories/${category.id}", category).as[Category]

  def list(opts: Map[String, String]): List[Category] =
    client.get("/categories.json", opts).as[CategoryListContainer].category_list.categories

  def get(id: Int): Category =
    client.get(s"/c/$id/show.json").as[CategoryContainer].category
}
