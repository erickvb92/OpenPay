package com.upax.openpay.model
import com.google.gson.annotations.SerializedName

data class Response_review (

	@SerializedName("id"             ) var id            : String?        = null,
	@SerializedName("author"         ) var author        : String?        = null,
	@SerializedName("author_details" ) var authorDetails : AuthorDetails? = AuthorDetails(),
	@SerializedName("content"        ) var content       : String?        = null,
	@SerializedName("created_at"     ) var createdAt     : String?        = null,
	@SerializedName("iso_639_1"      ) var iso6391       : String?        = null,
	@SerializedName("media_id"       ) var mediaId       : Int?           = null,
	@SerializedName("media_title"    ) var mediaTitle    : String?        = null,
	@SerializedName("media_type"     ) var mediaType     : String?        = null,
	@SerializedName("updated_at"     ) var updatedAt     : String?        = null,
	@SerializedName("url"            ) var url           : String?        = null

)