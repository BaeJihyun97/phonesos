package phonesos.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phonesos.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/lostItemReports")
@Transactional
public class LostItemReportController {

    @Autowired
    LostItemReportRepository lostItemReportRepository;

    @RequestMapping(
        value = "/lostItemReports/report",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public LostItemReport report(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReportCommand reportCommand
    ) throws Exception {
        System.out.println("##### /lostItemReport/report  called #####");
        LostItemReport lostItemReport = new LostItemReport();
        lostItemReport.report(reportCommand);
        lostItemReportRepository.save(lostItemReport);
        return lostItemReport;
    }

    @RequestMapping(
        value = "/lostItemReports/{id}/resolve",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LostItemReport resolve(
        @PathVariable(value = "id") Long id,
        @RequestBody ResolveCommand resolveCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lostItemReport/resolve  called #####");
        Optional<LostItemReport> optionalLostItemReport = lostItemReportRepository.findById(
            id
        );

        optionalLostItemReport.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        LostItemReport lostItemReport = optionalLostItemReport.get();
        lostItemReport.resolve(resolveCommand);

        lostItemReportRepository.save(lostItemReport);
        return lostItemReport;
    }

    @RequestMapping(
        value = "/lostItemReports/{id}/markitemfound",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LostItemReport markItemFound(
        @PathVariable(value = "id") Long id,
        @RequestBody MarkItemFoundCommand markItemFoundCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lostItemReport/markItemFound  called #####");
        Optional<LostItemReport> optionalLostItemReport = lostItemReportRepository.findById(
            id
        );

        optionalLostItemReport.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        LostItemReport lostItemReport = optionalLostItemReport.get();
        lostItemReport.markItemFound(markItemFoundCommand);

        lostItemReportRepository.save(lostItemReport);
        return lostItemReport;
    }

    @RequestMapping(
        value = "/lostItemReports/{id}/marklongtermlost",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LostItemReport markLongTermLost(
        @PathVariable(value = "id") Long id,
        @RequestBody MarkLongTermLostCommand markLongTermLostCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /lostItemReport/markLongTermLost  called #####"
        );
        Optional<LostItemReport> optionalLostItemReport = lostItemReportRepository.findById(
            id
        );

        optionalLostItemReport.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        LostItemReport lostItemReport = optionalLostItemReport.get();
        lostItemReport.markLongTermLost(markLongTermLostCommand);

        lostItemReportRepository.save(lostItemReport);
        return lostItemReport;
    }
}
//>>> Clean Arch / Inbound Adaptor
