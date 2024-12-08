import scala.annotation.tailrec

val sampleDirections1 = "LR"
val sampleInput1 = "11A = (11B, XXX)\n11B = (XXX, 11Z)\n11Z = (11B, XXX)\n22A = (22B, XXX)\n22B = (22C, 22C)\n22C = (22Z, 22Z)\n22Z = (22B, 22B)\nXXX = (XXX, XXX)"

val puzzleDirections = "LRRRLRRRLRRLRLRRLRLRRLRRLRLLRRRLRLRLRRRLRRRLRLRLRLLRRLLRRLRRRLLRLRRRLRLRLRRRLLRLRRLRRRLRLRRRLLRLRRLRRRLRRLRRLRLRRLRRRLRLRRRLRRLLRRLRRLRLRRRLRRLRRRLRRRLRLRRLRLRRRLRLRRLRRLRRRLRRRLRRRLLRRLRRRLRLRLRLRRRLRLRLRRLRRRLRRRLRRLRRLLRLRRLLRLRRLRRLLRLLRRRLLRRLLRRLRRLRLRLRRRLLRRLRRRR"
val puzzleInput = "DBQ = (RTP, NBX)\nNFX = (PXX, PLG)\nVBK = (BRV, DKG)\nBRS = (HLR, VBX)\nDDK = (SPR, TCR)\nFTS = (LJB, MDJ)\nBLH = (DFM, GGG)\nPCC = (GQR, RHD)\nQKN = (VVR, GBL)\nKHN = (FNB, LLT)\nHTD = (NPJ, BTL)\nFPL = (BRX, XQD)\nRCJ = (QKN, XPD)\nXRN = (RMQ, LQB)\nHGM = (VPV, SVR)\nRFG = (TLM, KPH)\nSSG = (QGC, KJV)\nLPA = (QQN, GNF)\nSVN = (VLM, BDX)\nVPF = (TTR, RNQ)\nVNK = (DSX, MCZ)\nKMS = (XNN, MTB)\nRLS = (NHX, CRT)\nVRS = (VBX, HLR)\nTVK = (MKG, NKB)\nCKH = (DFF, XPV)\nKBS = (LJC, PRS)\nJMT = (FPT, DLX)\nLRV = (QCD, RLF)\nTMM = (VPF, GKD)\nHKH = (PRS, LJC)\nGSM = (SVH, KRP)\nSLG = (PTL, SNJ)\nGVS = (DSN, CKH)\nQGC = (HKS, DFP)\nRFT = (VVQ, GMF)\nFDF = (JKV, JKV)\nMRL = (PKS, TKS)\nHBN = (BDX, VLM)\nCFB = (PPV, QVS)\nTFJ = (KGN, JND)\nHLB = (PFV, JXR)\nRFJ = (SKL, QCN)\nPQH = (KGN, JND)\nHGR = (FKL, XHR)\nCTB = (HNQ, HNQ)\nXMN = (CJV, LKQ)\nJVX = (FSS, CRC)\nSFH = (MXD, RHN)\nBRK = (QPL, DJB)\nHBX = (DSN, CKH)\nRFL = (VXB, FNF)\nGXP = (LHR, SMV)\nCHK = (NLQ, VCR)\nQPG = (HHL, KHB)\nVBC = (NFV, FST)\nQJF = (JXL, JJC)\nXKQ = (PCS, BSH)\nSKS = (SNN, QSN)\nGJJ = (VVG, XPR)\nDJP = (SJM, DNR)\nDQF = (MHG, BKZ)\nMSB = (BRX, XQD)\nPQR = (TLL, RVS)\nXGB = (RMT, HGF)\nHBD = (PFD, FDN)\nNSN = (RFJ, NJT)\nSNJ = (MVG, DBQ)\nNMV = (SKG, TDJ)\nPTN = (TNR, SSG)\nSBG = (CVH, LMJ)\nRDT = (SVQ, JTT)\nMRC = (BKF, QMJ)\nJKV = (CTB, CTB)\nCTX = (QHL, BDV)\nSQM = (DNR, SJM)\nMVG = (RTP, NBX)\nKKJ = (TQP, PST)\nQKX = (BRD, SFT)\nVFV = (NTL, VMQ)\nLXK = (SSL, MFR)\nHDH = (VPS, MJH)\nRTP = (CGJ, XJC)\nBXQ = (FLN, FLN)\nGKD = (TTR, RNQ)\nGPP = (SNN, QSN)\nGDQ = (JLS, TND)\nLTF = (GXP, TVB)\nGVB = (LSV, FRL)\nJCF = (HGR, GMX)\nVCR = (JTR, MCM)\nXJC = (DGP, XML)\nXKA = (SFC, CHQ)\nLJL = (VPX, PMS)\nCPH = (PCQ, QKX)\nVPV = (TFP, NJN)\nTDJ = (PRV, DBK)\nJGQ = (TPX, NMV)\nLJS = (GDQ, QPV)\nVHN = (CBJ, PFQ)\nJHT = (XHM, NRK)\nZZZ = (HJS, LRV)\nKJV = (HKS, DFP)\nHNT = (XXT, KJT)\nRHD = (KQH, TMD)\nJKG = (HXJ, MGF)\nSPL = (TTB, STB)\nMBD = (CQK, NHH)\nTPX = (TDJ, SKG)\nHRC = (LBB, JLR)\nQHN = (JHT, THC)\nSPM = (DDG, MBK)\nMFG = (JBD, GSM)\nMHR = (PTN, HVB)\nRLF = (GMG, TDQ)\nXBQ = (KKN, QTN)\nGLB = (DHS, SXC)\nPRV = (PGC, NSK)\nSJD = (BXQ, GHF)\nTHC = (XHM, NRK)\nGBL = (GGR, HTK)\nMDK = (JXX, DBD)\nNJT = (QCN, SKL)\nLLG = (KBL, LXK)\nRVS = (DDB, QRV)\nLHR = (LPL, TGJ)\nTBD = (NNB, CQH)\nDSN = (DFF, XPV)\nQQN = (HRV, PTT)\nXPP = (GSJ, RDT)\nCBJ = (JQL, RBX)\nRBX = (CNV, NKQ)\nDDG = (NBS, KTV)\nXNN = (TMC, GCG)\nDSX = (CGR, SGM)\nDFB = (RCJ, KJK)\nXTG = (RFG, XSD)\nPKQ = (DBD, JXX)\nXPD = (GBL, VVR)\nFFC = (JLR, LBB)\nGMG = (KFH, PTP)\nQHJ = (SHM, FKM)\nMXD = (XGB, LTX)\nSGM = (FTS, GXX)\nLTX = (RMT, HGF)\nRNQ = (SPL, DKH)\nNHF = (VXC, HRS)\nKFR = (JXR, PFV)\nNRP = (XNN, MTB)\nVDR = (LDL, JCP)\nFSS = (KXJ, GKL)\nQVS = (MKN, BLH)\nSNN = (SBM, PNH)\nVXB = (LLG, BHP)\nBPK = (QVS, PPV)\nSMV = (TGJ, LPL)\nCXF = (XKV, PVR)\nPGC = (NBJ, KCK)\nVLG = (DDG, MBK)\nFKL = (HFC, XPP)\nKFC = (XNM, CNR)\nFCC = (BRK, GLT)\nHQC = (JKV, JHQ)\nQQV = (CPG, HQD)\nVVG = (XGJ, XGJ)\nSVK = (HVH, HNJ)\nXQT = (LQX, HNT)\nJDB = (PXM, THR)\nJHR = (XRF, DHN)\nHRS = (TFJ, PQH)\nSVQ = (XHX, QNG)\nKGN = (FCV, SBH)\nGJX = (MFG, LMS)\nNBJ = (GVB, RMS)\nVQJ = (JPB, PDF)\nTKX = (JMT, LGM)\nFLL = (GTX, HKP)\nMFT = (FKM, SHM)\nJCP = (SSP, VMD)\nLPC = (KCD, JDB)\nXHR = (XPP, HFC)\nFKM = (DLL, XBQ)\nMGF = (NFX, MQS)\nJXJ = (MMP, CBT)\nDFP = (TGM, RHV)\nSSM = (NTC, TMT)\nDLX = (PXF, SBG)\nNNB = (TNT, MMF)\nQNG = (RHP, QBT)\nFLR = (CJK, QRL)\nRCP = (KKG, NTD)\nGJV = (SLG, DGN)\nFDN = (TBR, QDT)\nJTG = (RFT, PRC)\nLGM = (DLX, FPT)\nQDT = (CXV, SGD)\nHKP = (BLB, PCL)\nGXB = (MNH, GXT)\nQDS = (LTF, FDX)\nLMJ = (GJV, HVV)\nTDQ = (PTP, KFH)\nSGD = (HTT, PNR)\nXPV = (BPM, CPH)\nPTP = (MKL, KSP)\nDKG = (DKK, KNQ)\nQCN = (XTD, GQM)\nLSV = (GDK, VVD)\nMLG = (RLS, RKG)\nGMX = (FKL, XHR)\nQSN = (PNH, SBM)\nCHQ = (KSB, CXF)\nRHN = (LTX, XGB)\nLVX = (JSF, MLT)\nXHM = (FLR, QVK)\nNCJ = (CPG, HQD)\nMQV = (HBD, LDK)\nVVD = (QBV, FKF)\nQCD = (GMG, TDQ)\nGTH = (DLJ, DQF)\nKFH = (KSP, MKL)\nNFC = (PKQ, MDK)\nNCD = (FNB, LLT)\nMKG = (HNS, DDK)\nBTV = (KBS, HKH)\nQGL = (QTF, CVS)\nDDB = (DVF, HXV)\nPXF = (CVH, LMJ)\nNFV = (XMN, BQR)\nDGN = (SNJ, PTL)\nHHL = (PHC, QQJ)\nXPR = (XGJ, LVQ)\nPCQ = (BRD, SFT)\nMMT = (RDS, SRS)\nDMR = (GJM, BQS)\nQPL = (XNQ, CMN)\nPDF = (JBH, CTX)\nCVR = (STX, MBQ)\nLPL = (SFL, PHQ)\nFXX = (PNX, PQL)\nKLS = (NHG, CHF)\nNHX = (TMN, JLJ)\nNND = (QHN, XBR)\nJTT = (QNG, XHX)\nLML = (FDX, LTF)\nPCS = (LKV, LXX)\nSRV = (KCD, JDB)\nNSK = (NBJ, KCK)\nMRF = (NKP, JKG)\nVPX = (NSN, SMB)\nGFT = (FPL, MSB)\nDFM = (XKQ, PPQ)\nPPQ = (PCS, BSH)\nJJC = (JHR, RQG)\nJBH = (BDV, QHL)\nKNQ = (KNP, MRL)\nTBS = (NTD, KKG)\nJXL = (RQG, JHR)\nGKL = (MJC, QBM)\nBQR = (LKQ, CJV)\nDGP = (VNT, JRB)\nDKR = (VBJ, GVF)\nJXN = (BXD, XLT)\nTVG = (HGR, GMX)\nXSD = (TLM, KPH)\nRMT = (GXB, DPT)\nFRL = (VVD, GDK)\nPNX = (NCD, KHN)\nVGK = (CNR, XNM)\nMQB = (KSF, LJS)\nKDC = (MSB, FPL)\nGCD = (CXS, PCC)\nXML = (VNT, JRB)\nTBL = (GCV, HDH)\nBRV = (DKK, KNQ)\nJKS = (XXB, ZZZ)\nTMC = (MDQ, QJF)\nTNT = (NQJ, SSM)\nFLF = (XSD, RFG)\nJRB = (FDF, HQC)\nPTL = (DBQ, MVG)\nBGQ = (KFR, HLB)\nXTD = (VRS, BRS)\nQXX = (SJD, CSH)\nFRX = (BQS, GJM)\nPQL = (NCD, KHN)\nLKV = (PNK, DKR)\nHQS = (VVG, XPR)\nVPQ = (NTL, VMQ)\nTHR = (CBV, CVR)\nFST = (BQR, XMN)\nDMD = (CVS, QTF)\nHXV = (RCP, TBS)\nSTM = (RFX, BFR)\nJTR = (JTL, JXN)\nFLG = (PFQ, CBJ)\nCKM = (KFB, HTP)\nNCT = (KJK, RCJ)\nDKH = (STB, TTB)\nQGA = (CGR, SGM)\nXNQ = (HJM, MLG)\nRGF = (LFN, FGC)\nQBV = (VPJ, RMN)\nQKJ = (KFC, VGK)\nCSB = (FDL, FDL)\nHFK = (DHS, SXC)\nSVP = (NPJ, BTL)\nGGR = (XTG, FLF)\nXKV = (NDH, JXJ)\nBMR = (FRX, DMR)\nVVQ = (BFN, TVK)\nHJM = (RKG, RLS)\nRLK = (PDF, JPB)\nDCX = (HNQ, BRZ)\nTBG = (RTL, SML)\nRMS = (FRL, LSV)\nFCV = (STM, HTC)\nSPR = (TBL, JGG)\nBHP = (LXK, KBL)\nNPJ = (XLV, PQR)\nNKF = (TBD, DKP)\nPDK = (JTK, JTK)\nPFQ = (RBX, JQL)\nLBB = (SVP, HTD)\nGTX = (BLB, PCL)\nSBH = (HTC, STM)\nBFR = (RJN, BTN)\nTCR = (TBL, JGG)\nMQS = (PXX, PLG)\nFRG = (XXB, XXB)\nSTX = (XQL, HGM)\nHNJ = (HBN, SVN)\nSSL = (RDL, NST)\nHJS = (QCD, RLF)\nKBL = (SSL, MFR)\nCXS = (RHD, GQR)\nDFD = (NFP, FCC)\nVBJ = (HFK, GLB)\nDKP = (NNB, CQH)\nQSK = (TKX, CQT)\nBNV = (JTK, GTH)\nNBH = (LVX, GQB)\nQBM = (VNC, VPK)\nDBD = (HHR, RVQ)\nDFF = (BPM, CPH)\nLQX = (KJT, XXT)\nFGC = (QKQ, QSK)\nPXM = (CBV, CVR)\nJHQ = (CTB, DCX)\nNJN = (BGQ, FBP)\nTLL = (DDB, QRV)\nXSN = (THS, KJQ)\nKXJ = (QBM, MJC)\nGSC = (TQG, QXX)\nQJP = (PQL, PNX)\nPHH = (MXD, RHN)\nSSC = (NQX, FCH)\nXDF = (NLQ, VCR)\nBRD = (MQV, FRQ)\nAAA = (LRV, HJS)\nPTT = (FFC, HRC)\nVKF = (BFG, TGQ)\nHHA = (FLG, VHN)\nCNR = (TQX, VDV)\nTGM = (FLL, TNV)\nGLT = (DJB, QPL)\nMBK = (NBS, KTV)\nJPB = (JBH, CTX)\nRHP = (SQM, DJP)\nCHF = (CLQ, JGQ)\nFTL = (PRC, RFT)\nSKL = (XTD, GQM)\nRBN = (SPM, VLG)\nHGF = (GXB, DPT)\nBQS = (NSP, BTV)\nXHX = (RHP, QBT)\nCGR = (GXX, FTS)\nBLB = (QJP, FXX)\nCRT = (JLJ, TMN)\nPLG = (SLC, PDD)\nHRV = (FFC, HRC)\nMCM = (JXN, JTL)\nJGH = (MFG, LMS)\nNSP = (KBS, HKH)\nMFR = (NST, RDL)\nGMF = (TVK, BFN)\nSML = (LJL, XFP)\nMPL = (RDS, SRS)\nQHP = (SPM, VLG)\nFCH = (GDC, XRN)\nNRQ = (FTL, JTG)\nHMB = (CRC, FSS)\nKPH = (BNH, SLK)\nSRS = (MQB, GCN)\nRQM = (TGQ, BFG)\nFLN = (CSB, CSB)\nBSH = (LKV, LXX)\nCRC = (KXJ, GKL)\nCJV = (XDF, CHK)\nCGJ = (DGP, XML)\nSFL = (GJJ, HQS)\nPMR = (VPF, GKD)\nQTN = (MMT, MPL)\nKJQ = (RLK, VQJ)\nPBJ = (LFN, FGC)\nBTL = (PQR, XLV)\nSBX = (KFC, VGK)\nQQJ = (PDK, BNV)\nBRZ = (GNF, QQN)\nJTL = (XLT, BXD)\nSKG = (PRV, DBK)\nRQG = (DHN, XRF)\nDRC = (SFC, CHQ)\nTJQ = (NQX, FCH)\nPKS = (TMM, PMR)\nTRP = (GVD, FBL)\nLKQ = (XDF, CHK)\nRTL = (XFP, LJL)\nPPV = (MKN, BLH)\nMTB = (GCG, TMC)\nFPT = (PXF, SBG)\nLDK = (FDN, PFD)\nTND = (PPX, SVK)\nVPK = (NHF, JDX)\nHTP = (NKF, RPV)\nPMS = (SMB, NSN)\nGGG = (XKQ, PPQ)\nDLL = (KKN, QTN)\nJXX = (HHR, RVQ)\nKSF = (QPV, GDQ)\nXQD = (FGK, BNJ)\nRJF = (CSB, KTM)\nGCN = (KSF, LJS)\nJKP = (LML, QDS)\nXFP = (VPX, PMS)\nDPT = (GXT, MNH)\nDKK = (KNP, MRL)\nNKB = (DDK, HNS)\nCJK = (GSC, GBQ)\nNLM = (LDL, JCP)\nVMD = (DFD, XFM)\nNBX = (XJC, CGJ)\nPRS = (NLM, VDR)\nRMQ = (FRG, FRG)\nXNM = (TQX, VDV)\nLJC = (VDR, NLM)\nPHQ = (GJJ, HQS)\nKXN = (KHB, HHL)\nBXD = (CKM, XVL)\nKFB = (NKF, RPV)\nNFS = (PRL, RFL)\nRJN = (SFV, RRG)\nGQM = (VRS, BRS)\nKQH = (VBC, BSJ)\nDNR = (BMR, LJQ)\nHHR = (LPC, SRV)\nDLJ = (MHG, MHG)\nSMB = (RFJ, NJT)\nRHV = (FLL, TNV)\nNTD = (HBX, GVS)\nVNT = (FDF, HQC)\nPRC = (GMF, VVQ)\nFBP = (HLB, KFR)\nKTM = (FDL, LRZ)\nTQP = (QGL, DMD)\nSBM = (QPG, KXN)\nQVK = (CJK, QRL)\nXRF = (RGF, PBJ)\nNDH = (CBT, MMP)\nGVL = (RTL, SML)\nLRZ = (VHN, FLG)\nCQH = (MMF, TNT)\nSLK = (TJQ, SSC)\nQBT = (SQM, DJP)\nFNF = (LLG, BHP)\nSTB = (KMS, NRP)\nHVV = (SLG, DGN)\nRFX = (BTN, RJN)\nMKL = (GVM, LVP)\nVDV = (BPK, CFB)\nCBT = (GJX, JGH)\nPPX = (HVH, HNJ)\nNQJ = (TMT, NTC)\nMJH = (MHP, XQT)\nLTA = (KLS, BFV)\nCSH = (BXQ, GHF)\nHTK = (XTG, FLF)\nVNC = (JDX, NHF)\nBFG = (MRC, NKK)\nKKG = (GVS, HBX)\nPNK = (GVF, VBJ)\nXXB = (LRV, HJS)\nDVF = (TBS, RCP)\nPNR = (NCJ, QQV)\nQKQ = (CQT, TKX)\nTTR = (SPL, DKH)\nBTN = (RRG, SFV)\nVLM = (PHH, SFH)\nTQG = (SJD, CSH)\nMHP = (LQX, HNT)\nNQX = (GDC, XRN)\nTQX = (BPK, CFB)\nTVB = (LHR, SMV)\nMBQ = (XQL, HGM)\nHXJ = (MQS, NFX)\nDHN = (PBJ, RGF)\nBFN = (MKG, NKB)\nPVR = (JXJ, NDH)\nQRL = (GBQ, GSC)\nGJM = (NSP, BTV)\nKQV = (NHH, CQK)\nKNP = (TKS, PKS)\nPDD = (FND, JKP)\nGXT = (VKF, RQM)\nXDC = (FTL, JTG)\nMMF = (SSM, NQJ)\nBFV = (CHF, NHG)\nDHS = (PHX, PHX)\nVXC = (PQH, TFJ)\nXLV = (TLL, RVS)\nPXX = (SLC, PDD)\nGVD = (DRC, DRC)\nTHS = (VQJ, RLK)\nDBK = (PGC, NSK)\nKHB = (PHC, QQJ)\nTKS = (PMR, TMM)\nSVR = (NJN, TFP)\nHNQ = (QQN, GNF)\nMKN = (GGG, DFM)\nKRP = (NFM, NFC)\nSHM = (XBQ, DLL)\nNTL = (NCT, DFB)\nNRK = (QVK, FLR)\nHXL = (DSX, DSX)\nKSB = (XKV, PVR)\nNKK = (BKF, QMJ)\nMHG = (KLS, BFV)\nPNP = (XBR, QHN)\nCLQ = (TPX, NMV)\nRSG = (XDC, NRQ)\nBPM = (PCQ, QKX)\nPHC = (PDK, BNV)\nTNR = (KJV, QGC)\nXQL = (VPV, SVR)\nMHV = (QTS, RSG)\nXBR = (THC, JHT)\nBDX = (PHH, SFH)\nTBR = (CXV, SGD)\nRVQ = (SRV, LPC)\nNFM = (PKQ, MDK)\nFBL = (DRC, QSZ)\nTLM = (BNH, SLK)\nNHH = (SKS, GPP)\nFKF = (RMN, VPJ)\nXVL = (HTP, KFB)\nNHG = (CLQ, JGQ)\nFGK = (NBH, KBX)\nVMQ = (DFB, NCT)\nLXX = (DKR, PNK)\nSMJ = (QGB, NFS)\nLVP = (KDC, GFT)\nQGB = (PRL, RFL)\nBRX = (BNJ, FGK)\nBDV = (MRF, RXX)\nSJM = (BMR, LJQ)\nGBQ = (TQG, QXX)\nJXR = (XJT, CVX)\nTMN = (XSN, PQM)\nCQT = (LGM, JMT)\nCPG = (QHP, RBN)\nBKZ = (BFV, KLS)\nVVR = (HTK, GGR)\nXFM = (NFP, FCC)\nCVH = (GJV, HVV)\nVPS = (XQT, MHP)\nMDJ = (QHJ, MFT)\nSNF = (QTS, RSG)\nNKQ = (HMB, JVX)\nPRL = (FNF, VXB)\nCMN = (MLG, HJM)\nJQL = (NKQ, CNV)\nQSZ = (CHQ, SFC)\nHLR = (MHV, SNF)\nRDL = (TBG, GVL)\nGVM = (KDC, GFT)\nKTV = (CKK, VBK)\nSLC = (JKP, FND)\nQHL = (MRF, RXX)\nKKN = (MPL, MMT)\nTNV = (HKP, GTX)\nQMJ = (TVG, JCF)\nBSJ = (NFV, FST)\nBNJ = (NBH, KBX)\nXXQ = (GCD, CMQ)\nTGQ = (NKK, MRC)\nSVH = (NFC, NFM)\nLQB = (FRG, JKS)\nGNF = (HRV, PTT)\nPFV = (CVX, XJT)\nJTK = (DLJ, DLJ)\nKSP = (LVP, GVM)\nPFD = (TBR, QDT)\nMLT = (KSQ, KKJ)\nGVF = (HFK, GLB)\nJLS = (PPX, SVK)\nTBK = (CMQ, GCD)\nLJB = (QHJ, MFT)\nKSQ = (PST, TQP)\nSXC = (PHX, TRP)\nTTB = (NRP, KMS)\nVBX = (MHV, SNF)\nCXV = (PNR, HTT)\nXCT = (NFS, QGB)\nJBD = (KRP, SVH)\nJDX = (HRS, VXC)\nBNH = (TJQ, SSC)\nHQD = (RBN, QHP)\nRXX = (NKP, JKG)\nNTC = (NND, PNP)\nQTF = (TVQ, MHR)\nJND = (FCV, SBH)\nRDS = (MQB, GCN)\nFDL = (FLG, VHN)\nTGJ = (SFL, PHQ)\nKBX = (GQB, LVX)\nGQR = (TMD, KQH)\nLMS = (JBD, GSM)\nVPJ = (SMJ, XCT)\nLVQ = (HXL, VNK)\nGDK = (QBV, FKF)\nKCD = (PXM, THR)\nJGG = (GCV, HDH)\nNFP = (BRK, GLT)\nSFV = (TBK, XXQ)\nKJK = (QKN, XPD)\nCVX = (SBX, QKJ)\nGCG = (QJF, MDQ)\nFNB = (VFV, VPQ)\nCBV = (STX, MBQ)\nPNH = (QPG, KXN)\nHFC = (GSJ, RDT)\nGHF = (FLN, RJF)\nCKK = (BRV, DKG)\nLFN = (QKQ, QSK)\nMNH = (VKF, RQM)\nMMP = (GJX, JGH)\nHVB = (SSG, TNR)\nTMD = (BSJ, VBC)\nQTS = (NRQ, XDC)\nTVQ = (PTN, HVB)\nHTT = (QQV, NCJ)\nPQM = (KJQ, THS)\nXJT = (QKJ, SBX)\nPST = (QGL, DMD)\nXXT = (MBD, KQV)\nPCL = (QJP, FXX)\nMJC = (VPK, VNC)\nQPV = (JLS, TND)\nJLJ = (PQM, XSN)\nBKF = (TVG, JCF)\nSFT = (FRQ, MQV)\nXGJ = (HXL, HXL)\nJSF = (KKJ, KSQ)\nRMN = (XCT, SMJ)\nRPV = (TBD, DKP)\nXLT = (CKM, XVL)\nDJB = (CMN, XNQ)\nKCK = (GVB, RMS)\nLLT = (VFV, VPQ)\nCVS = (MHR, TVQ)\nNBS = (VBK, CKK)\nLJQ = (DMR, FRX)\nHKS = (TGM, RHV)\nHTC = (BFR, RFX)\nLDL = (VMD, SSP)\nQRV = (HXV, DVF)\nNST = (TBG, GVL)\nGQB = (JSF, MLT)\nKJT = (MBD, KQV)\nGSJ = (SVQ, JTT)\nFDX = (TVB, GXP)\nSSP = (XFM, DFD)\nFRQ = (LDK, HBD)\nJLR = (HTD, SVP)\nHNS = (SPR, TCR)\nMCZ = (SGM, CGR)\nGCV = (VPS, MJH)\nMDQ = (JJC, JXL)\nRKG = (NHX, CRT)\nTMT = (NND, PNP)\nSFC = (KSB, CXF)\nCQK = (SKS, GPP)\nFND = (LML, QDS)\nHVH = (HBN, SVN)\nCNV = (HMB, JVX)\nCMQ = (CXS, PCC)\nNLQ = (JTR, MCM)\nGDC = (RMQ, RMQ)\nPHX = (GVD, GVD)\nNKP = (HXJ, MGF)\nRRG = (XXQ, TBK)\nTFP = (BGQ, FBP)\nGXX = (LJB, MDJ)"

case class Node (currentNode:String, leftStep: String, rightStep: String)


def parse(line: String): Node =
  val s"$currentNode = ($leftStep, $rightStep)" = line: @unchecked
  Node(currentNode = currentNode, leftStep = leftStep, rightStep = rightStep)

def getNextStep(directions: String, step: Long) : String =
//  println(f"getting next step for directions: $directions and step $step")
  if(step > directions.length) then
    directions(((step-1) % directions.length).toInt).toString
  else
    directions(step.toInt-1).toString

@tailrec
def moveToNextNode(nodeMap: Map[String, Node], currentNodes: List[Node], directions: String, step: Long): Long =
  val nextStep = getNextStep(directions, step)

//  if step == 104147483646L then
  //if step == 10L then
    //return 999

  val nextNodes = if nextStep == "L"  then
    currentNodes.map(elem => nodeMap(elem.leftStep))
  else currentNodes.map(elem => nodeMap(elem.rightStep))

//  println(nextNodes.count(_.currentNode.endsWith("Z")))
//  println(nextNodes.length)

  if (nextNodes.count(_.currentNode.endsWith("Z")) == nextNodes.length)
//      println(nextStep)
//      println(f"Current nodes are: $node1 Next step is ${nextNode1.currentNode} and $node2 Next step is ${nextNode2.currentNode}, Step: $step")
    step
  else
//      println(f"Current node is: $node1 with direction: $nextStep, Next step is $nextNode1.currentNode and $node2 Next step is $nextNode2.currentNode, Step: $step")
    moveToNextNode(nodeMap, nextNodes, directions, step + 1)


def findStartingNodes(nodeMap: Map[String, Node]): List[Node] =
  nodeMap.filter(elem => elem._1.endsWith("A")).values.toList

def solution(directions: String, nodeMapRaw: String): Long =
  val nodeMap = nodeMapRaw.linesIterator.map(parse).map(elem => elem.currentNode -> elem).toMap
  val startNodes = findStartingNodes(nodeMap)
  println(startNodes)

  moveToNextNode(nodeMap, startNodes, directions, 1)

solution(sampleDirections1, sampleInput1)
solution(puzzleDirections, puzzleInput)
//547691 too low
