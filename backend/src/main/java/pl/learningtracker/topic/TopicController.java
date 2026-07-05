package pl.learningtracker.topic;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> findAll() {
        return topicService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Topic create(@Valid @RequestBody TopicRequest request) {
        return topicService.create(request);
    }

    @PatchMapping("/{id}/status")
    public Topic updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        TopicStatus status = TopicStatus.valueOf(body.get("status"));
        return topicService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        topicService.delete(id);
    }

    @ExceptionHandler(TopicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleTopicNotFound(TopicNotFoundException exception) {
        return Map.of("message", exception.getMessage());
    }
}
