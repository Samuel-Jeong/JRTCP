package rtcp;

import network.rtcp.base.RtcpHeader;
import network.rtcp.base.RtcpType;
import network.rtcp.type.RtcpReceiverReport;
import network.rtcp.type.base.RtcpReportBlock;
import org.apache.commons.net.ntp.TimeStamp;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.module.ByteUtil;

import java.util.ArrayList;
import java.util.List;

public class RtcpReceiverReportTest {

    private static final Logger logger = LoggerFactory.getLogger(RtcpReceiverReportTest.class);

    @Test
    public void test() {
        byte[] data = creationTest();
        getTest(data);
    }

    private byte[] creationTest() {
        long curTime = TimeStamp.getCurrentTime().getTime();

        // HEADER
        RtcpHeader rtcpHeader = new RtcpHeader(2, 0, 1, RtcpType.RECEIVER_REPORT, 7, 26422708);

        // REPORT BLOCK LIST
        List<RtcpReportBlock> rtcpReportBlockList = new ArrayList<>();
        RtcpReportBlock source1 = new RtcpReportBlock(
                1569920308,
                (byte) 0,
                1,
                50943,
                76,
                curTime,
                35390
        );
        rtcpReportBlockList.add(source1);

        // RtcpReceiverReport
        RtcpReceiverReport rtcpReceiverReport = new RtcpReceiverReport(
                rtcpHeader,
                rtcpReportBlockList,
                null
        );
        logger.debug("[RtcpReceiverReportTest][creationTest] RtcpSenderReport: \n{}", rtcpReceiverReport);

        byte[] rtcpReceiverReportData = rtcpReceiverReport.getData();
        logger.debug("[RtcpReceiverReportTest][creationTest] RtcpSenderReport byte data: \n{}", rtcpReceiverReport);
        logger.debug("[RtcpReceiverReportTest][creationTest] RtcpSenderReport byte data: \n{}", ByteUtil.byteArrayToHex(rtcpReceiverReportData));
        return rtcpReceiverReportData;
    }

    private void getTest(byte[] data) {
        RtcpReceiverReport rtcpReceiverReport = new RtcpReceiverReport(data);
        logger.debug("[RtcpReceiverReportTest][getTest] ReportBlock: \n{}", rtcpReceiverReport);
    }

}