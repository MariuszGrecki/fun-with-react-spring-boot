package pl.learningtracker.topic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public Topic create(TopicRequest request) {
        return topicRepository.save(new Topic(request.title()));
    }

    @Transactional
    public Topic updateStatus(Long id, TopicStatus status) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new TopicNotFoundException(id));

        topic.changeStatus(status);
        return topic;
    }

    public void delete(Long id) {
        if (!topicRepository.existsById(id)) {
            throw new TopicNotFoundException(id);
        }

        topicRepository.deleteById(id);
    }
}
