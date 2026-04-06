
package GithubAPIIntegration.demo.Controllers;


import org.springframework.web.bind.annotation.*;

import GithubAPIIntegration.demo.Dtos.IssueRequest;
import GithubAPIIntegration.demo.Services.GithubService;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService service;

    public GithubController(GithubService service) {
        this.service = service;
    }

    // 🔹 Get Repositories
    @GetMapping("/repos/{username}")
    public String getRepos(@PathVariable String username) {
        return service.getRepos(username);
    }

    // 🔹 Create Issue
    @PostMapping("/issue/{owner}/{repo}")
    public String createIssue(
            @PathVariable String owner,
            @PathVariable String repo,
            @RequestBody IssueRequest request) {

        return service.createIssue(owner, repo, request);
    }

    // 🔹 List Issues
    @GetMapping("/issues/{owner}/{repo}")
    public String listIssues(
            @PathVariable String owner,
            @PathVariable String repo) {

        return service.listIssues(owner, repo);
    }
}