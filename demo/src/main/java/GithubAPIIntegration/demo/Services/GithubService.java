package GithubAPIIntegration.demo.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import GithubAPIIntegration.demo.Dtos.IssueRequest;

@Service
public class GithubService {

    private final RestTemplate restTemplate;

    @Value("${github.token}")
    private String token;

    public GithubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        // Ensure "Bearer " has a space after it
        headers.set("Authorization", "Bearer " + token.trim());
        headers.set("Accept", "application/vnd.github+json");
        
        // 🔹 CRITICAL: GitHub API requires a User-Agent header
        headers.set("User-Agent", "Spring-Boot-Github-Integration");
        
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public String getRepos(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        HttpEntity<String> entity = new HttpEntity<>(getHeaders());
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }

    public String createIssue(String owner, String repo, IssueRequest request) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/issues";
        // Pass the request body and the headers
        HttpEntity<IssueRequest> entity = new HttpEntity<>(request, getHeaders());
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }

    public String listIssues(String owner, String repo) {
        String url = "https://api.github.com/repos/" + owner + "/" + repo + "/issues";
        HttpEntity<String> entity = new HttpEntity<>(getHeaders());
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
    }
}