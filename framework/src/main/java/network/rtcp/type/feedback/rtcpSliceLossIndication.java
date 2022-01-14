package network.rtcp.type.feedback;

public class rtcpSliceLossIndication extends RtcpFeedback {

    /**
     * Slice Loss Indication
     *
     *   The SLI FB message is identified by PT=PSFB and FMT=2.
     *
     *    The FCI field MUST contain at least one and MAY contain more than one
     *    SLI.
     *
     *   The Slice Loss Indication uses one additional FCI field, the content
     *    of which is depicted in Figure 6.  The length of the FB message MUST
     *    be set to 2+n, with n being the number of SLIs contained in the FCI
     *    field.
     *    (Syntax of the Slice Loss Indication (SLI))
     *
     *     0                   1                   2                   3
     *     0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
     *    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     *    |            First        |        Number           | PictureID |
     *    +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
     *
     *   First: 13 bits
     *       The macroblock (MB) address of the first lost macroblock.  The MB
     *       numbering is done such that the macroblock in the upper left
     *       corner of the picture is considered macroblock number 1 and the
     *       number for each macroblock increases from left to right and then
     *       from top to bottom in raster-scan order (such that if there is a
     *       total of N macroblocks in a picture, the bottom right macroblock
     *       is considered macroblock number N).
     *
     *   Number: 13 bits
     *       The number of lost macroblocks, in scan order as discussed above.
     *
     *    PictureID: 6 bits
     *       The six least significant bits of the codec-specific identifier
     *       that is used to reference the picture in which the loss of the
     *       macroblock(s) has occurred.  For many video codecs, the PictureID
     *       is identical to the Temporal Reference.
     *
     *    The applicability of this FB message is limited to a small set of
     *    video codecs; therefore, no explicit payload type information is
     *    provided.
     *
     *
     */

}
