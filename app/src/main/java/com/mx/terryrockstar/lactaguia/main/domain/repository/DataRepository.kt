package com.mx.terryrockstar.lactaguia.main.domain.repository

import com.mx.terryrockstar.lactaguia.R
import com.mx.terryrockstar.lactaguia.main.domain.model.SubTopic
import com.mx.terryrockstar.lactaguia.main.domain.model.Topic

class DataRepository {

    val list: MutableList<Topic> = dataSet()

    private fun dataSet(): MutableList<Topic>{
        val topicList = mutableListOf<Topic>()
        for (i in 1..14) {
            topicList.add(getTopic(i))
        }
        return topicList
    }

    private fun getTopic(id: Int): Topic {
        val subTopicList = mutableListOf<SubTopic>()
        var title: Int = -1
        var text: Int = -1
        var image: Int = -1
        when(id) {
            1 -> {
                title = R.string.topic_1
                image = R.drawable.ic_ico_1
                subTopicList.add(SubTopic(1, R.string.subtopic_1_1, R.string.subtopic_1_1_text))
                subTopicList.add(SubTopic(2, R.string.subtopic_1_2, R.string.subtopic_1_2_text))
            }
            2 -> {
                title = R.string.topic_2
                text = R.string.topic_2_text
                image = R.drawable.ic_ico_2
                subTopicList.add(SubTopic(1, R.string.subtopic_2_1, R.string.subtopic_2_1_text))
                subTopicList.add(SubTopic(2, R.string.subtopic_2_2, R.string.subtopic_2_2_text))
                subTopicList.add(SubTopic(3, R.string.subtopic_2_3, R.string.subtopic_2_3_text))
            }
            3 -> {
                title = R.string.topic_3
                image = R.drawable.ic_ico_3
                subTopicList.add(SubTopic(1, R.string.subtopic_3_1, R.string.subtopic_3_1_text))
                subTopicList.add(SubTopic(2, R.string.subtopic_3_2, R.string.subtopic_3_2_text))
                subTopicList.add(SubTopic(3, R.string.subtopic_3_3, R.string.subtopic_3_3_text))
            }
            4 -> {
                title = R.string.topic_4
                text = R.string.topic_4_text
                image = R.drawable.ic_ico_4
                subTopicList.add(SubTopic(1, R.string.subtopic_4_1, R.string.subtopic_4_1_text))
                subTopicList.add(SubTopic(2, R.string.subtopic_4_2, R.string.subtopic_4_2_text))
                subTopicList.add(SubTopic(3, R.string.subtopic_4_3, R.string.subtopic_4_3_text))
            }
            5 -> {
                title = R.string.topic_5
                text = R.string.topic_5_text
                image = R.drawable.ic_ico_5
                subTopicList.add(SubTopic(50, R.string.topic_5, R.string.topic_5_text_0))
                subTopicList.add(SubTopic(51, R.string.topic_5, R.string.topic_5_text_1))
                subTopicList.add(SubTopic(52, R.string.topic_5, R.string.topic_5_text_2))
                subTopicList.add(SubTopic(53, R.string.topic_5, R.string.topic_5_text_3))
            }
            6 -> {
                title = R.string.topic_6
                image = R.drawable.ic_ico_6
                subTopicList.add(SubTopic(1, R.string.subtopic_6_1, R.string.subtopic_6_1_text))
                subTopicList.add(SubTopic(2, R.string.subtopic_6_2, R.string.subtopic_6_2_text))
                subTopicList.add(SubTopic(3, R.string.subtopic_6_3, R.string.subtopic_6_3_text))
            }
            7 -> {
                title = R.string.topic_7
                text = R.string.topic_7_text
                image = R.drawable.ic_ico_7
                subTopicList.add(SubTopic(1, R.string.subtopic_7_1, R.string.subtopic_7_1_text))
                subTopicList.add(SubTopic(2, R.string.subtopic_7_2, R.string.subtopic_7_2_text))
                subTopicList.add(SubTopic(3, R.string.subtopic_7_3, R.string.subtopic_7_3_text))
            }
            8 -> {
                title = R.string.topic_8
                text = R.string.topic_8_text
                image = R.drawable.ic_ico_8
            }
            9 -> {
                title = R.string.topic_9
                text = R.string.topic_9_text
                image = R.drawable.ic_ico_9
            }
            10 -> {
                title = R.string.topic_10
                text = R.string.topic_10_text
                image = R.drawable.ic_ico_10
            }
            11 -> {
                title = R.string.topic_11
                image = R.drawable.ic_ico_11
                subTopicList.add(SubTopic(1, R.string.subtopic_11_1, R.string.subtopic_11_1_text))
                subTopicList.add(SubTopic(2, R.string.subtopic_11_2, R.string.subtopic_11_2_text))
                subTopicList.add(SubTopic(3, R.string.subtopic_11_3, R.string.subtopic_11_3_text))
            }
            12 -> {
                title = R.string.topic_12
                text = R.string.topic_12_text
                image = R.drawable.ic_ico_12
            }
            13 -> {
                title = R.string.topic_13
                text = R.string.topic_13_text
                image = R.drawable.ic_ico_13
            }
            14 -> {
                title = R.string.topic_14
                text = R.string.topic_14_text
                image = R.drawable.ic_ico_14
            }
        }
        return Topic(id, title, image, subTopicList, text)
    }

}