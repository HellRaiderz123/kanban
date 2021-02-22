package com.mytasknowcobackend.kanban.api;

import com.mytasknowcobackend.kanban.model.Issues;
import com.mytasknowcobackend.kanban.service.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/issues")
@RestController
public class IssuesController {

	private final IssuesService issuesService;
    @Autowired
    public IssuesController(IssuesService issuesService) {
        this.issuesService = issuesService;
    }

  //  @ApiOperation(value = "Create an issue")
    @PostMapping
    public void addIssue(@RequestBody Issues issue) {
    	issuesService.addIssue(issue);
    }
    
    @GetMapping
    public List<Issues> returnAllIssues(){
    	return issuesService.returnAllIssues();
    }

    @GetMapping(path = "{issueId}")
    public  Issues selectIssuebyId(@PathVariable ("issueId") String issueId) { return issuesService.selectIssuebyId(issueId); }

    @DeleteMapping(path = "{issueId}")
    public void deleteIssuebyId(@PathVariable("issueId") String issueId){
        issuesService.deleteIssuebyId(issueId);
    }

    @PutMapping(path = "{issueId}")
    public  int  updateIsssuebyId(@PathVariable("issueId") String issueId, @RequestBody Issues updatedIssue){
        return issuesService.updateIssuebyId(issueId,updatedIssue);
    }

}
