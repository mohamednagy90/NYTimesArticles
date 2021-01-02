package com.nytimesarticles.util


interface OnListItemClickListener<in T> {
	fun onListItemClick(item: T?)
}

interface OnListItemLongClickListener<in T> {
	fun onListItemLongClick(item: T?)
}