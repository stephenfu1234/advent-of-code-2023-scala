import scala.collection.mutable
import scala.collection.mutable.{HashMap, ListBuffer}

val sampleRules = "px{a<2006:qkq,m>2090:A,rfg}\npv{a>1716:R,A}\nlnx{m>1548:A,A}\nrfg{s<537:gd,x>2440:R,A}\nqs{s>3448:A,lnx}\nqkq{x<1416:A,crn}\ncrn{x>2662:A,R}\nin{s<1351:px,qqz}\nqqz{s>2770:qs,m<1801:hdj,R}\ngd{a>3333:R,R}\nhdj{m>838:A,pv}"
val sampleParts = "{x=787,m=2655,a=1222,s=2876}\n{x=1679,m=44,a=2067,s=496}\n{x=2036,m=264,a=79,s=2244}\n{x=2461,m=1339,a=466,s=291}\n{x=2127,m=1623,a=2188,s=1013}"
val puzzleRules = "ddr{a>2798:R,A}\nzb{s>3079:sx,rx}\npgr{m>252:R,R}\ndd{s>1564:R,A}\nsqd{s<826:A,R}\ntkz{a>1736:gd,s>1750:zb,a>1393:sc,bbf}\ntj{s>1798:phz,R}\nqrz{s>1229:A,a<1073:A,R}\nnmx{a>1003:fs,x>2904:gz,jm}\nfz{s<294:R,s>482:snn,hdp}\nzlt{s<770:vt,a>1176:R,lfj}\ntbv{x>337:A,m<235:A,x<161:R,A}\nsnk{a>2034:A,x<3415:vng,R}\nqqx{s<200:R,A}\ndvj{x<553:R,a<1863:A,m>740:R,A}\ncfk{m>3282:tf,a<2958:st,gr}\nhft{s>1176:jdq,m>3798:R,a>3444:A,R}\ncj{s>2549:pgz,m<3504:A,gj}\nfgv{s<1421:vj,a>3706:jc,rpt}\nrbx{s>3004:R,m>2706:A,a>3138:R,R}\nnxr{x>485:R,s>2194:ps,a<1111:A,A}\nhmg{x>1816:R,fvj}\nqpz{x>1024:R,s<1964:mr,A}\nkxd{s>1481:cd,x>3253:nv,s>1331:ghj,jvh}\nrxt{m<2228:R,A}\nsqm{x<3201:zm,a<2875:tn,x>3674:gdj,fd}\nhbr{a>1931:R,s>180:A,a<1750:R,A}\nnnr{s>174:R,s>61:R,mc}\nsq{m>1969:A,x>2216:A,R}\nrc{x>2822:R,R}\nspc{m<2762:R,s>1852:R,A}\ntnb{a<3945:A,R}\nmdv{m>815:R,s<1880:A,m>686:tr,A}\npvh{s>1812:ncr,a>787:rbl,sv}\nprd{x>3543:R,m>3768:R,a>665:A,A}\nfsj{m>578:src,a>2100:pfs,s>566:ztb,hcc}\ntc{s<549:jvz,m<3063:xxx,zpz}\nhkt{x<2178:A,s<2724:R,R}\njt{m>2168:vnm,x>2989:cqd,a<1638:A,pp}\nlg{a>2726:R,s<446:R,A}\njkh{x<959:rb,s>2379:A,x>1369:R,R}\nknh{x<2508:nj,s<1999:xst,sn}\nzmr{m>3494:R,A}\nlvc{s>3454:xmp,x<3262:mlt,x>3715:knj,qlv}\ntq{s>2625:zh,a<3098:R,a>3149:tbv,R}\nfvk{s<1128:A,s<1510:R,s>1689:A,A}\npm{s>326:R,a<3814:R,A}\ngdj{x>3801:A,qnt}\nmbv{a>3289:fgv,cfk}\ntg{m>3750:R,R}\nhkg{a<943:nnr,gsf}\nsrq{a<74:R,a<130:R,A}\nmmc{a>3048:R,s<1277:A,R}\nkvt{x>2236:xs,m>526:kz,R}\ntcz{s<465:A,R}\nzpp{s>2545:R,A}\nhfr{x>964:jg,x>434:A,s>2313:ptd,dft}\ncs{a>3127:A,s>1505:A,R}\nssv{s<2464:xk,x<3193:R,A}\nkn{m<1681:A,A}\nsn{a<1108:kx,x>3194:lf,nvk}\nnj{m>3612:zz,a<804:xn,tkz}\nvvh{a<745:R,R}\njzp{m<2082:mh,x<3880:kcz,x<3924:zhl,kb}\nrnk{m<1088:A,A}\nzjg{a<2189:grx,a<2373:R,kxr}\ntbq{x<3539:A,m>1653:qd,s>1420:A,R}\nmg{s>1614:frt,a<2925:zmz,m>807:mmc,R}\njtd{s>2047:A,x<703:R,A}\njj{a>1161:R,x<2656:R,a<995:R,A}\ndxg{x>3110:A,R}\nds{x<2034:R,qqn}\nmmf{a>1568:A,a<1067:R,s>1588:A,A}\nplq{m>1007:brc,m<616:kd,x>3029:pr,mg}\nztt{s<3039:R,m<3660:R,a>938:R,R}\nckd{m<3116:A,a>784:A,m<3238:R,R}\nin{m>2613:mqg,jz}\nslb{m<3449:R,m>3570:A,m<3527:A,R}\nlfj{x<2863:A,m>3749:A,R}\nznf{a>242:A,m>1648:A,A}\nvhq{m<669:bxk,dv}\ngdx{m<2716:djj,a<863:bv,m<2770:mvb,tb}\nqr{s<2369:A,R}\njss{x>1008:R,jk}\nkdq{a>3528:A,x<1774:A,m>3616:R,R}\nljr{s<833:fz,bqp}\njrf{a<2974:A,m>2024:A,m>1507:R,A}\ndkd{m<900:vhq,x>1029:tt,rl}\njvz{a<1924:R,m<3105:R,a>2167:R,A}\ntqk{a>3594:R,x>801:R,A}\ncq{a>1177:R,R}\nkq{a<1123:R,m>3094:A,a<1530:R,R}\nlml{x>1762:R,A}\nkj{x>1377:A,a>1052:bzl,s<1239:gh,A}\nhd{s>3363:kdq,m>3494:kpv,x<2088:R,sjg}\nbs{a<1398:A,pzn}\ntjp{s>642:A,s<274:A,R}\ngh{m<1943:A,a>873:R,A}\ngcv{a>3134:R,a>3060:R,m>876:R,R}\ngrx{m>2093:A,A}\nkc{s>3105:A,A}\nsrc{m<831:dj,x>3323:fpp,x<3033:rcz,R}\nqdr{x<3045:A,x>3523:R,s>2410:A,A}\njzz{s>165:A,s<139:A,A}\nqz{a>500:A,a>467:R,R}\nlcz{m>3613:R,bh}\nltg{x<3563:R,R}\nsv{a<407:ppc,m<3065:npm,x<2043:vd,lv}\nvt{m>3691:A,R}\nfc{s>3580:A,x>3580:R,m<2684:R,A}\nqlv{x<3495:kv,m>1641:rsh,qm}\nxk{m<2107:R,R}\nct{m>1397:mf,a>2728:R,qjx}\nbn{m>2347:A,a<1246:R,m>2265:R,R}\nvc{x>3916:R,m>221:R,pv}\nkx{x>3250:sb,a>690:xx,a<375:tcn,bt}\nht{x>2793:A,A}\ncpn{a>1571:R,s>2405:A,R}\nvsv{a<1610:bp,s<2022:xrc,m<233:A,A}\nzhl{m<2322:A,m<2431:A,A}\ndft{a<334:R,A}\nxzx{s<2182:A,a>3672:A,a>3398:R,A}\njq{s<1944:dks,m<536:jx,dkd}\nmnt{x>560:R,A}\nqx{a>295:R,a<243:A,A}\nbt{x>2848:R,m<3541:A,m<3696:vns,R}\nfmf{s>2653:dp,s>2156:vbt,mnl}\nsh{m<3696:R,qr}\nphz{a>3401:A,R}\nvvt{m>2836:A,A}\ndrx{m>2943:R,a<2843:R,A}\nxvg{a<2898:pc,x<779:tq,x<1271:xr,dh}\nng{a>2280:R,a>2096:R,s<2892:R,R}\nspt{x<2821:R,m<3963:A,R}\njvh{m<3544:zjm,qrz}\nlhd{s>2406:R,s>2147:R,R}\ncsj{a<1809:gcx,x<2870:A,A}\nznc{m>1029:nb,m<568:xvg,gpc}\nsc{x>1139:A,gkf}\nknj{m>1187:jzp,m>422:dss,x>3846:vc,vxq}\nnq{a<1396:vvt,x>2573:A,a>1437:A,A}\npzg{x<2750:phx,s>3244:A,s<2595:lk,R}\nzk{a>2850:ccf,R}\nvcd{m>641:dvj,s>2884:R,a>1975:R,A}\nxrz{a>2064:R,m>127:R,m<65:R,A}\nstc{x<1970:R,x>2056:R,A}\nbxk{s<2364:A,s>2467:R,A}\nzn{a>3014:R,a>2873:A,R}\nrcz{x>2759:A,s<958:A,m>954:A,A}\nhcb{m<2013:A,s>2981:nrk,x>303:sls,kqx}\nqp{m>2178:R,m>2082:A,x>2255:A,A}\npz{s>471:ztl,a<1253:cpt,A}\nls{x<810:R,R}\nkd{s>1899:A,s>1547:R,R}\ngv{m<2081:R,R}\nfdx{a<314:R,mnt}\nhg{a<3005:A,s<389:R,A}\nsx{x<1574:A,m<3509:A,a<1349:A,R}\nphx{a>1835:R,A}\ngt{s>689:A,a<2436:A,m<2003:A,A}\nfvj{m<1606:A,s<1419:A,s>2630:A,A}\nlzz{m>1106:ghk,m>948:vjc,vcq}\nptd{m>2679:A,x<189:R,a>306:A,A}\nztb{s<1002:sqd,R}\njvb{s>1917:R,m>1667:A,A}\nlqt{a>2860:A,A}\nmpb{s<3272:R,A}\nblt{x<2808:R,x>3531:A,x>3057:R,A}\ncx{s<1499:R,R}\npr{a<3003:R,s<1595:R,m<772:vm,gcv}\ncn{x>3044:A,s>1727:A,x>2688:R,A}\ngr{m>2864:gp,s<2297:cv,bnb}\nnpm{a>551:khp,a<457:A,fvk}\nxkg{x<832:tsx,s>1599:A,x>1225:A,R}\nxl{a<677:qz,a<863:tgk,m<1010:A,prg}\nnv{a<1459:A,s<1275:A,a<2009:rh,A}\ntn{s<715:A,m>638:A,pgr}\ntfm{s<1144:R,m>3349:A,R}\nsnn{a<846:A,m>552:A,a>1361:R,A}\nbpp{x<2807:A,R}\nvd{x>1118:R,m<3207:R,nc}\nzgl{x<3069:A,A}\nrgc{x>68:R,a<1503:A,x<63:R,A}\nfcp{a<1763:glv,ng}\nnc{a>617:A,x>384:R,s<636:A,A}\nskr{m>2782:xjd,m>2686:pg,s>2459:jss,cg}\nmvg{a>2944:fzp,m<2234:A,s>677:A,xj}\nbzq{s<1857:A,s>3241:A,x<2111:R,A}\nkb{a>2931:R,x<3952:A,A}\nrsc{a>1197:R,x>3490:R,A}\nzr{m>575:A,a<3057:A,m>349:A,R}\nxb{m>2163:A,A}\nst{s<2565:jdb,a>2686:rbt,crc}\ndbz{s<2674:R,s>2736:A,m>1032:lrq,R}\nmlt{x>2447:lqt,m>1039:ndr,x>2128:kvt,stc}\ndv{m<775:R,a>1523:A,A}\nvg{x>3418:A,a>1276:R,s>2674:A,R}\nrbl{s>1168:mmf,x>1541:bs,a<1410:fv,tc}\npjs{x>958:R,A}\nvcq{a<1857:thv,m>892:R,x<990:A,R}\nrq{a<917:A,x<414:A,A}\nrf{m<1262:A,a>3128:R,a<3058:ksj,pt}\nzpz{m<3183:R,a<1779:A,s>905:A,A}\nvxq{m>147:rgh,x>3760:R,a>3001:rv,A}\njc{s<2493:qnd,a>3874:tnb,a>3804:mfr,gxl}\ngjh{a>1514:R,a>625:R,x>164:R,A}\ndss{x>3828:kc,m<788:A,R}\nxr{a>3063:R,m<337:R,fpz}\nnld{m<2654:R,s<3700:A,R}\nqjx{s>3611:R,s<3552:R,x<2696:R,A}\nmvq{x>163:R,a>565:A,m<1647:A,A}\nfpz{a<2989:A,R}\nnn{m<1680:vkb,x<1137:gv,cx}\nkgc{m<437:R,R}\nkqx{a<1294:A,R}\njcq{m<2505:R,s<639:R,A}\nqqg{s>326:R,x>3369:A,a<2324:A,R}\npt{s<524:R,s<781:A,R}\ngm{a>2868:A,A}\nncr{s>2837:mtj,a<1197:hfj,mb}\nlpg{x>3380:R,R}\nbj{x<3269:R,A}\ndfq{m<691:cq,x>822:A,s>3470:bg,npp}\nrz{x>2601:R,m>2835:R,R}\ndp{x>765:gjf,s<3522:hcb,x>306:txg,qf}\nxrc{s<1970:R,A}\nrh{s>1361:R,A}\nghj{m>3684:A,a>990:R,a<410:R,ncn}\njv{s>2332:R,x<828:R,a<1898:R,R}\npg{x<970:vk,m<2748:A,s>2580:fn,R}\nzm{m<484:ztr,x>2549:tjp,rcv}\nrb{m<1700:A,a>1720:A,m<1841:R,A}\njgr{s<2278:gzl,x>3200:pcx,csj}\npbn{x>374:R,m>384:R,a<3554:R,A}\nqkg{s<3824:A,x>2386:R,s>3926:A,R}\nvbq{m>3040:R,A}\nlz{s>1085:plq,m>965:ld,sqm}\ntd{a>917:bzq,s>1977:R,m>3831:A,R}\njmg{a>1456:sjh,x>1527:cfd,a<744:fdx,fnz}\ntb{a<1175:zbp,a>1338:nq,s>2522:rm,lb}\nxj{s<395:R,m<2424:A,R}\nrhs{m<2014:R,a>1821:A,s<924:R,R}\ncv{m>2764:cs,R}\nbxb{x>1615:rhs,s>963:dl,a>2179:gt,tlk}\nxzp{a<1209:A,s>496:A,R}\nncn{s>1413:R,a<684:A,s>1363:A,R}\nhtb{x>781:A,R}\nsr{a<3035:A,s>2691:R,x>3355:A,A}\ndks{s>1731:ggg,m<612:xkg,dd}\npq{s>1524:A,s<1492:R,R}\nlsv{x>1488:R,m>682:R,R}\nvnm{s>325:A,m<2402:R,x<2727:R,R}\nrzx{x<1438:gq,m<3652:slb,a<3487:msf,R}\nzx{a<3832:A,s<3005:A,A}\nqd{a<3495:R,R}\ndlb{x<1083:A,x>1446:R,A}\npn{m<2978:qq,A}\nmjt{m<2741:A,a>1149:A,A}\nvjc{a<1865:A,x>735:A,x>260:fvx,A}\ndzp{x>3254:pz,zlt}\nxxd{s>511:zff,m<1627:hkg,s<194:jmg,bhf}\nqdm{a>3888:jb,s<1765:rc,zx}\nvj{a>3627:skj,s<785:rr,m>3517:hft,pn}\nmnl{s>1820:cdc,zxx}\nghk{a<1775:A,m<1202:rtb,A}\ndjj{x>1644:rvh,a>934:db,a<572:hfr,vvh}\njl{x>1510:R,s>3698:R,R}\nlv{a<638:R,A}\nzf{s>2014:R,a>138:A,m>2741:A,R}\nkcz{x>3781:R,A}\nvk{m>2729:A,s>2152:A,R}\nlh{a>1757:A,s>3057:R,A}\nsjh{x<1520:rpb,s<112:rxt,s<162:A,hbr}\nmt{a>621:A,s>2682:R,a<310:A,R}\ngsf{m<1314:A,R}\nbpj{m>657:A,R}\nrgh{s<2959:A,A}\nrhl{a<1360:A,R}\ncfd{s<114:xb,jzz}\ngvz{a<1302:A,s>1647:R,A}\nhxm{s>1871:A,x<1084:R,s>1104:A,R}\njdq{a>3489:R,R}\nzxx{m<2156:A,x<879:gvz,s<1638:pq,bn}\nsrf{a<1866:gx,lhd}\nnrk{x>366:R,s<3184:R,R}\nlbv{a>1341:xrz,x<1419:A,x>1850:A,R}\nmxk{x>287:zn,s>2665:jrf,s>903:A,kn}\njd{a<1733:R,m<606:jr,fnt}\nvl{a<3861:A,x<1824:R,m<3506:A,A}\ncd{s>1796:cdf,m<3564:knz,s<1640:R,cn}\ndb{a>1199:hxm,m>2651:A,x<1045:R,A}\njb{a<3935:A,bj}\nrtb{s>2904:A,s>2747:A,a<2280:A,R}\ngxl{a<3765:mpb,m<3465:A,R}\nmf{m>2047:A,m>1681:R,R}\ngz{s>2756:nth,x<3574:ms,s>2253:djk,gjc}\ngpc{x>852:mdv,a<3015:zk,tmk}\nmc{x>2270:R,R}\njcd{m>1107:xxd,nh}\nfl{x<2028:A,a<227:R,R}\nvbt{m<2049:jkh,a>1164:cf,lvg}\nzqf{a<3822:A,A}\nbqp{a<842:nd,s>1180:R,vzl}\nlkx{a>845:R,A}\nhdk{m<849:lsv,x<888:R,vxv}\nhcc{m>357:mj,R}\ncdc{s>1968:jtd,m<1932:jfr,A}\njk{a>1782:R,s>3073:R,m<2661:A,R}\nxd{x>2319:A,a<184:R,a>279:gnd,fl}\nnb{x>704:nn,mxk}\ntsx{a>1588:R,R}\ngnf{s<3282:R,m<558:A,R}\nfnt{x>971:A,R}\nlrq{a<775:R,A}\ntf{x<2149:zj,gm}\nrr{s>322:R,s<123:fj,a>3489:R,qqx}\nxxx{x>575:A,s<958:R,A}\nbdj{a>732:rj,x<829:A,A}\nlmz{a<3503:A,a<3817:A,a>3880:A,A}\nxf{x<974:A,A}\nfj{x<1622:A,x<3145:R,A}\nfzp{m<2314:A,m<2506:A,A}\nmjx{m>2024:dlb,m>1809:R,s<375:R,tcz}\nbhf{x>1806:jt,mjx}\njz{a>2604:gmh,s>1456:fg,jcd}\nqh{x>1294:hmg,m>1146:ls,s<1512:tdr,bbm}\nbrc{x<3270:jvb,R}\nvdt{x>1390:A,s<2347:R,a<1905:R,R}\nbh{s<3007:R,a>1748:R,A}\nvxv{m>957:R,A}\nndr{s>3055:sq,hkt}\nfrz{m<1886:A,a<920:A,s<3691:A,R}\nkkm{x<2217:qh,a>3736:qdm,bhl}\nkt{s>2791:bdj,x<693:txk,dbz}\nsjg{s>3104:R,m>3337:A,x>3065:R,A}\nfnz{a>1203:xf,A}\nrcv{m>788:A,s<433:R,A}\nvng{s<3130:A,A}\ntln{m<2744:A,x<1355:A,x>2713:A,R}\npcx{m>2761:qqp,s>3269:fc,s<2875:vr,lh}\nfrt{a>3002:A,x<2592:A,R}\nccf{s>2536:A,R}\ntr{m<753:R,R}\npxj{m<245:A,A}\njdb{m<2994:A,x>2068:zgl,A}\ndf{a<1303:hpv,m<460:zjn,vcd}\ngjf{x>1300:hc,R}\nbg{a<924:R,x>352:A,A}\nnd{a>462:A,A}\nrqz{x>2610:jgr,skr}\nsl{x<2852:A,a>929:A,R}\nppc{s>705:hfv,x<2163:pgl,blt}\nhgf{a>2761:A,s<3165:A,x>1544:A,A}\ncrc{s>3279:jl,A}\nmtj{s<3298:fls,kq}\nqf{a>1198:R,m<1861:mvq,m<2158:A,R}\nglv{m>1376:A,R}\njlv{x>3016:rsc,s>885:jj,x>2700:bpp,mjt}\npfs{s>632:dqb,qqg}\nprg{a<926:R,a<962:A,R}\nrx{s>2355:R,A}\nrj{s<2944:A,s>2996:A,A}\ntdr{x>514:tqk,m<726:lmz,a>3628:A,R}\nhcm{s>3082:sg,m<852:df,a<1232:kt,lzz}\ngd{x>951:R,x>504:R,R}\nzmz{m<766:A,x>2451:R,m<896:A,A}\nkng{a<853:R,a<1519:A,m<3824:R,A}\nzjm{m>3431:A,s<1230:R,m<3348:R,A}\nqnt{a<3079:A,R}\nzbp{m>2804:mk,A}\npzn{a>1913:A,x>2833:A,R}\ndqb{a>2325:A,s<947:A,m<212:R,R}\nfs{x<2573:fcp,m<1561:snk,a>1690:zjg,ssv}\npp{x<2300:A,R}\ngzl{m<2725:A,m>2775:tz,nss}\nztl{x>3661:R,x<3437:R,m>3609:R,A}\nkhp{x>2574:A,x<1419:R,A}\nztr{a<2880:A,x>2480:A,R}\nqnd{s<2020:R,m>3387:zqf,a<3823:dmt,R}\nqqp{a>2006:A,A}\nkv{s>3040:R,a>2895:sr,m<1471:ddr,R}\nnt{s>2367:A,a>1303:R,R}\ntmk{a<3096:sqx,nnh}\nrxn{x>3477:A,a<398:A,R}\nrvh{a<673:hm,s<2306:A,s<3287:R,nld}\nms{x>3284:rxn,s<2051:A,s<2439:rnk,mtv}\nns{a<678:A,R}\ngb{a>240:R,R}\ncl{x>3720:A,s>2112:R,R}\njm{a<407:xd,xl}\nmk{m>2843:R,m<2824:R,s<1575:R,R}\ntz{x<3359:R,s<849:A,R}\nvm{m<683:R,x<3518:A,A}\nkxr{m>2164:A,m<1956:R,R}\nmb{x>2135:qdr,vbq}\nmh{m<1597:R,s>3025:A,x<3866:A,R}\nmtv{x>3049:A,A}\ntt{a>1356:vdt,s>2243:A,a>773:R,R}\nmqg{a>2303:mbv,m<3306:nk,knh}\nnh{x<2460:dlm,a>1644:fsj,ljr}\nzh{m>197:A,A}\nvr{a>1986:A,s<2566:A,A}\nlk{a>1567:A,A}\nmj{a<1808:A,m>485:A,m<421:A,A}\nnnx{a>608:R,R}\ngg{s>679:kgc,R}\nch{m>2787:rz,x<2831:A,s>1282:spc,R}\npgl{a<226:A,x<1224:R,A}\ngmh{a>3230:kkm,x<1866:znc,s<2477:lz,lvc}\nbgq{m<2737:R,s<1260:A,A}\ndxb{x<2820:A,R}\ndjk{a<421:znf,R}\nxst{s<1163:dzp,kxd}\nfd{s>455:R,s<257:zr,hg}\nqc{s>2224:rq,lkx}\nkpv{x>1615:A,A}\nbv{a<387:ddq,x<1674:qpz,s<2321:ch,ns}\ncpt{x>3610:R,m<3682:A,R}\nfpp{a>2018:A,a>1868:A,A}\ngj{x<948:R,R}\nmr{x<572:A,a<692:R,s>1094:A,A}\nhv{m<3295:R,x<1384:R,A}\nxn{a<314:zmr,cj}\nps{a>1177:R,a>776:A,R}\ndl{s<1173:A,A}\nsqx{a<3049:A,s>2408:A,a>3072:R,R}\nxqh{s<2988:R,R}\nsg{s>3650:jd,s<3320:bpj,dfq}\nvp{m>2819:A,x>2720:A,m>2789:A,R}\nrpg{m<2003:A,a<678:gb,m<2355:qp,jcq}\ngkf{a>1508:R,A}\nfn{m<2766:A,s<3149:R,x<1536:A,A}\nhb{a<3475:A,x>2896:R,a<3628:A,R}\ntcn{a>191:qx,srq}\ncdf{a<786:R,x>3321:A,a<1323:R,A}\nmfr{a>3844:hv,R}\nqq{a<3503:A,x<1663:R,A}\nrsh{m<2002:R,R}\nbbf{m>3434:A,m<3379:tfm,cc}\ndlm{m>558:hdk,m<221:lbv,gg}\nrbt{x>2340:R,drx}\ngxs{x<3002:qkg,A}\nlj{a<1231:tln,m<2746:A,R}\ndmt{s<2284:R,a<3751:A,x<2605:A,R}\nnvk{x>2907:lcz,pzg}\nvkb{m>1293:R,x>1118:A,a<2919:R,A}\nfg{x>1593:nmx,m>1346:fmf,s<2603:jq,hcm}\nzz{x>1431:td,x>496:gs,x>274:qc,rg}\nnnh{m>725:R,a<3162:R,a>3198:A,R}\nggg{s>1811:A,x>709:kfl,A}\njr{s<3842:R,x<707:A,A}\ngcx{m<2731:R,a<1630:R,R}\nbr{a<3239:R,s>2349:A,x>2026:R,R}\npv{s<3019:R,A}\nxmf{x<3581:lpg,R}\nzmd{s>2733:A,R}\npc{x<1135:R,A}\ntxg{x<569:frz,m>2146:rhl,bqv}\nrl{x<436:gjh,a>946:jv,x<687:R,A}\nnkx{a<2858:lg,s>446:R,dxb}\nqqn{a>271:A,s>1249:A,s<1022:R,A}\njcv{a<936:R,A}\nsls{s<2814:R,s<2906:R,A}\ngp{a<3152:A,m<3054:A,br}\nxx{s<2697:sl,m<3685:R,m>3891:spt,A}\npnl{a>1466:rgm,x>1326:A,R}\nzff{a>1334:bxb,s<862:rpg,a<537:ds,kj}\nhpv{a<444:A,s<2920:A,xqh}\nvzl{a>1123:R,R}\nskj{s>808:vl,x<1558:pm,R}\ngs{s<1512:A,a<836:R,pjs}\nvxt{m<498:R,s<3284:R,A}\nlvg{x<725:A,R}\ndh{x<1589:A,s<1678:R,R}\nrpt{m<3237:zpp,s<2953:rzx,hd}\njfr{s>1873:R,s>1843:R,a>1060:A,A}\ncc{m<3414:A,s<928:A,A}\nbqv{s<3770:R,s<3883:R,R}\nknz{x<3310:R,A}\nmsf{m<3816:R,s<2083:R,A}\njx{x<971:nxr,s>2368:pxj,s<2162:vsv,pnl}\ngx{s>2596:R,A}\nkz{x>2182:R,s>3070:A,R}\nhfv{s<1371:A,R}\ncqd{s<300:A,R}\nlsh{x>3540:nt,vg}\ntlk{m>1701:R,a<1626:R,x<774:A,R}\nsb{a<511:ltg,a>804:ztt,prd}\nzj{x<1212:htb,s>2667:hgf,lml}\ncg{a>1779:R,x>1097:hz,A}\nhdp{a>807:A,A}\nvh{a<796:A,a<1044:A,A}\nhm{a<228:A,m<2648:R,m<2688:R,A}\nbnb{x>2224:R,x>1109:rbx,R}\nvgc{a>136:R,a<68:A,s<1478:A,A}\nfv{m>3015:R,a>1072:xzp,jcv}\nrpb{m<1992:R,x>868:R,A}\nnpp{m>1101:A,a<1712:R,R}\nrv{m<74:A,R}\nthv{m>889:R,s<2768:A,R}\nhfj{s<2435:ckd,s<2659:A,s>2727:vh,mt}\nxs{x>2330:A,m<442:R,A}\ntgk{a<792:R,m>1676:A,R}\ngq{m<3722:R,a<3517:A,R}\njg{x>1231:A,A}\nnk{m>2869:pvh,a<1459:gdx,rqz}\nbp{s<2044:A,a>687:A,A}\nqm{s>2931:A,m>743:R,tlz}\nld{m>1737:mvg,a<3019:nkx,rf}\nhz{x>2027:R,m>2654:A,R}\nvns{m>3638:A,m<3587:A,R}\nlb{s<1051:R,x<1757:R,s>1793:vp,ht}\ngjc{a<377:R,m>1276:R,s<1875:A,cl}\nxmp{a>2872:dxg,s<3724:ct,gxs}\ntlz{m<365:A,s<2643:R,R}\nnss{s<1355:A,R}\nrg{x>106:tg,x<60:kng,x>84:R,rgc}\nbzl{a<1152:R,m<1787:R,m<2251:R,R}\nhc{m<2176:A,R}\ngnd{x>1939:R,s<2440:A,x<1719:A,R}\nlf{s>3071:xmf,x>3723:sh,a<1538:lsh,srf}\ncqh{a<1319:A,a<1397:A,x>869:A,R}\ndj{x<3184:A,s<585:A,a<2100:A,R}\nrgm{m>297:A,x<1200:A,m>196:R,R}\nbbm{s>2862:vxt,x<843:pbn,xzx}\nxjd{s>2588:R,R}\nbhl{m<1089:kf,x>3004:tbq,tj}\nhf{s<904:R,a<1214:bgq,cqh}\nddq{m>2773:vgc,x>1533:zf,R}\nvf{s<2415:A,m>2358:A,a<2238:A,R}\nkfl{a<932:R,m<488:R,x>1179:A,R}\nrm{x>2088:R,R}\nzjn{s<2818:zmd,R}\nln{m>2079:R,m<1519:R,s<3470:R,R}\nnth{x>3316:nnx,m>1098:ln,x>3043:gnf,A}\nfvx{x>420:A,x>354:A,a<2171:R,A}\ntxk{s>2667:R,s<2634:A,s<2652:R,R}\ncf{a>1885:vf,m>2348:A,cpn}\nksj{x>3273:R,A}\nfls{m<3139:A,s>3101:A,a>1076:A,R}\nmvb{s>1870:lj,x>2228:jlv,hf}\npgz{x<1511:R,a>557:A,a<402:A,R}\nkf{s>1703:hb,m<483:A,A}"
val puzzleParts = "{x=637,m=679,a=312,s=22}\n{x=48,m=1047,a=228,s=744}\n{x=3643,m=1704,a=1029,s=1169}\n{x=53,m=1228,a=2175,s=653}\n{x=1424,m=1872,a=193,s=706}\n{x=347,m=2373,a=453,s=9}\n{x=1235,m=56,a=149,s=971}\n{x=296,m=433,a=693,s=37}\n{x=866,m=612,a=439,s=168}\n{x=1473,m=2481,a=293,s=837}\n{x=70,m=1712,a=705,s=1482}\n{x=680,m=262,a=3438,s=1628}\n{x=866,m=1085,a=276,s=812}\n{x=349,m=1359,a=353,s=1425}\n{x=78,m=2976,a=283,s=89}\n{x=616,m=174,a=448,s=1260}\n{x=663,m=859,a=21,s=1652}\n{x=821,m=2075,a=1837,s=172}\n{x=1557,m=1003,a=3035,s=597}\n{x=1001,m=2006,a=21,s=2646}\n{x=2165,m=433,a=850,s=1261}\n{x=2554,m=2904,a=2220,s=44}\n{x=170,m=173,a=315,s=847}\n{x=25,m=1416,a=1000,s=1056}\n{x=488,m=1742,a=1363,s=600}\n{x=254,m=1506,a=23,s=2837}\n{x=286,m=267,a=861,s=1183}\n{x=32,m=1317,a=458,s=851}\n{x=1859,m=750,a=987,s=1257}\n{x=1386,m=588,a=143,s=1439}\n{x=540,m=1047,a=470,s=44}\n{x=1458,m=1859,a=2116,s=973}\n{x=435,m=297,a=3008,s=791}\n{x=1275,m=84,a=259,s=605}\n{x=128,m=607,a=309,s=462}\n{x=357,m=2506,a=2124,s=1844}\n{x=128,m=215,a=247,s=7}\n{x=3130,m=2544,a=605,s=1577}\n{x=562,m=3681,a=2009,s=546}\n{x=986,m=1191,a=1572,s=197}\n{x=133,m=6,a=1660,s=751}\n{x=359,m=153,a=291,s=2259}\n{x=423,m=83,a=315,s=633}\n{x=647,m=95,a=47,s=2840}\n{x=2233,m=346,a=1284,s=2448}\n{x=319,m=3302,a=1638,s=16}\n{x=2874,m=520,a=322,s=595}\n{x=560,m=10,a=1705,s=2771}\n{x=1553,m=2551,a=1402,s=3532}\n{x=254,m=210,a=122,s=759}\n{x=3214,m=183,a=1767,s=2712}\n{x=1297,m=704,a=995,s=387}\n{x=165,m=794,a=1588,s=3378}\n{x=15,m=1006,a=1211,s=1987}\n{x=627,m=381,a=3207,s=2822}\n{x=1506,m=8,a=656,s=649}\n{x=49,m=138,a=455,s=247}\n{x=1024,m=224,a=1316,s=528}\n{x=56,m=115,a=1077,s=248}\n{x=30,m=1802,a=55,s=553}\n{x=1722,m=127,a=2903,s=370}\n{x=1218,m=2366,a=1710,s=1513}\n{x=1146,m=3065,a=973,s=1740}\n{x=263,m=1997,a=2035,s=3459}\n{x=974,m=1322,a=40,s=42}\n{x=998,m=136,a=9,s=3001}\n{x=1826,m=2737,a=230,s=1259}\n{x=67,m=334,a=270,s=61}\n{x=603,m=535,a=507,s=3315}\n{x=131,m=1009,a=234,s=1575}\n{x=263,m=1587,a=1830,s=99}\n{x=2090,m=1638,a=489,s=2219}\n{x=870,m=275,a=504,s=3082}\n{x=1052,m=19,a=1116,s=2059}\n{x=814,m=77,a=2578,s=1010}\n{x=131,m=3,a=2878,s=2398}\n{x=699,m=2124,a=420,s=576}\n{x=902,m=932,a=3906,s=1246}\n{x=343,m=215,a=262,s=51}\n{x=967,m=1205,a=210,s=181}\n{x=2547,m=413,a=602,s=667}\n{x=477,m=41,a=306,s=255}\n{x=218,m=757,a=197,s=1051}\n{x=369,m=702,a=1123,s=1482}\n{x=2706,m=1331,a=520,s=1210}\n{x=917,m=743,a=1941,s=1847}\n{x=217,m=2342,a=388,s=974}\n{x=450,m=439,a=1254,s=318}\n{x=2475,m=1480,a=1809,s=2789}\n{x=2414,m=1388,a=227,s=926}\n{x=1390,m=3189,a=581,s=1240}\n{x=14,m=1797,a=40,s=512}\n{x=553,m=373,a=896,s=1240}\n{x=1585,m=111,a=604,s=416}\n{x=974,m=1014,a=969,s=157}\n{x=2710,m=655,a=2667,s=1779}\n{x=328,m=2415,a=828,s=312}\n{x=3747,m=366,a=368,s=579}\n{x=835,m=463,a=794,s=2219}\n{x=187,m=986,a=812,s=400}\n{x=1988,m=98,a=423,s=15}\n{x=1353,m=2340,a=465,s=2676}\n{x=1757,m=3396,a=389,s=1415}\n{x=33,m=78,a=1429,s=15}\n{x=2994,m=595,a=142,s=1224}\n{x=523,m=273,a=94,s=574}\n{x=3061,m=214,a=28,s=1265}\n{x=844,m=1053,a=2558,s=469}\n{x=60,m=197,a=189,s=21}\n{x=174,m=2924,a=94,s=1004}\n{x=591,m=277,a=402,s=38}\n{x=3317,m=651,a=438,s=252}\n{x=1412,m=631,a=611,s=776}\n{x=287,m=768,a=58,s=464}\n{x=3522,m=149,a=14,s=432}\n{x=240,m=1505,a=1076,s=1624}\n{x=390,m=112,a=1212,s=180}\n{x=109,m=1406,a=263,s=2793}\n{x=1276,m=991,a=762,s=998}\n{x=297,m=489,a=50,s=1450}\n{x=1007,m=1658,a=2814,s=1308}\n{x=473,m=1415,a=2684,s=106}\n{x=250,m=1795,a=410,s=593}\n{x=1303,m=1588,a=157,s=442}\n{x=838,m=312,a=515,s=1488}\n{x=2121,m=2257,a=2331,s=496}\n{x=555,m=2223,a=2326,s=272}\n{x=200,m=9,a=14,s=2016}\n{x=3255,m=176,a=120,s=2796}\n{x=1599,m=1313,a=2679,s=3245}\n{x=435,m=542,a=738,s=2288}\n{x=533,m=284,a=1358,s=442}\n{x=470,m=2071,a=133,s=2502}\n{x=2600,m=2063,a=332,s=494}\n{x=143,m=264,a=1001,s=161}\n{x=1148,m=206,a=921,s=237}\n{x=1611,m=626,a=476,s=319}\n{x=1060,m=814,a=2173,s=158}\n{x=1848,m=494,a=1279,s=1555}\n{x=632,m=572,a=295,s=2047}\n{x=1119,m=1454,a=1058,s=86}\n{x=2193,m=544,a=2138,s=906}\n{x=874,m=1325,a=1439,s=1961}\n{x=1925,m=2476,a=850,s=1701}\n{x=1104,m=2098,a=5,s=1434}\n{x=918,m=3299,a=292,s=3522}\n{x=1633,m=1140,a=2744,s=37}\n{x=755,m=288,a=670,s=621}\n{x=89,m=1084,a=81,s=722}\n{x=3165,m=950,a=461,s=716}\n{x=555,m=2675,a=2652,s=356}\n{x=1427,m=38,a=935,s=1}\n{x=1298,m=604,a=1940,s=562}\n{x=1560,m=1313,a=25,s=2665}\n{x=1576,m=1882,a=897,s=136}\n{x=776,m=1456,a=130,s=1934}\n{x=76,m=26,a=441,s=1171}\n{x=530,m=1294,a=115,s=79}\n{x=1613,m=1263,a=78,s=1949}\n{x=27,m=1011,a=1026,s=673}\n{x=2703,m=1438,a=1356,s=3536}\n{x=132,m=526,a=367,s=2659}\n{x=2650,m=719,a=1185,s=1158}\n{x=1048,m=390,a=1985,s=2896}\n{x=411,m=235,a=1177,s=592}\n{x=518,m=3120,a=1005,s=1362}\n{x=80,m=63,a=216,s=1783}\n{x=671,m=101,a=164,s=2676}\n{x=1104,m=401,a=2830,s=117}\n{x=1102,m=265,a=886,s=285}\n{x=317,m=489,a=166,s=781}\n{x=902,m=996,a=1611,s=879}\n{x=1820,m=1245,a=1181,s=673}\n{x=144,m=2642,a=40,s=2092}\n{x=1297,m=1641,a=196,s=3085}\n{x=269,m=127,a=460,s=211}\n{x=2,m=821,a=1267,s=55}\n{x=159,m=534,a=2143,s=97}\n{x=1281,m=166,a=496,s=227}\n{x=1407,m=768,a=59,s=2109}\n{x=2013,m=41,a=528,s=515}\n{x=648,m=1004,a=472,s=1039}\n{x=3644,m=3335,a=1785,s=185}\n{x=2532,m=966,a=614,s=377}\n{x=1579,m=291,a=1835,s=37}\n{x=1027,m=234,a=544,s=1028}\n{x=763,m=231,a=661,s=49}\n{x=1281,m=388,a=103,s=340}\n{x=148,m=595,a=439,s=483}\n{x=3322,m=246,a=272,s=442}\n{x=672,m=935,a=536,s=366}\n{x=51,m=2137,a=1026,s=1307}\n{x=2049,m=1351,a=331,s=1107}\n{x=654,m=2120,a=45,s=3656}\n{x=2912,m=165,a=1577,s=128}\n{x=388,m=43,a=837,s=281}\n{x=373,m=1362,a=33,s=949}\n{x=556,m=747,a=45,s=769}\n{x=72,m=1008,a=327,s=77}\n{x=2739,m=143,a=89,s=48}"

case class Workflow(workflowName: String, rules: List[String])
case class Part(ratings: mutable.HashMap[String, Int]) {
  def totalRating: Int = ratings.values.sum
}

var acceptedParts = ListBuffer[Part]()
var acceptedRanges = ListBuffer[mutable.HashMap[String, Range.Inclusive]]()
//var rejectedParts = ListBuffer[Part]()

def lessThan(): (Int, Int) => Boolean =
  (value: Int, compareValue: Int) => value < compareValue

def moreThan(): (Int, Int) => Boolean =
  (value: Int, compareValue: Int) => value > compareValue

val lessThanFunction = lessThan()
val moreThanFunction = moreThan()


def parseWorkflows(input: String): mutable.HashMap[String,Workflow] =
  var workflows = mutable.HashMap[String,Workflow]()
  input.linesIterator.foreach( line =>
    val (s"$workflowName{$rulesRaw}") = line: @unchecked

    val rules = rulesRaw.split(",").toList

    workflows(workflowName) = Workflow(workflowName = workflowName, rules = rules)
  )

  workflows

def parseParts(input: String): List[Part] =
  input.linesIterator.map( line =>
    val (s"{$parts}") = line: @unchecked

    val ratings = mutable.HashMap[String, Int]()
    parts.split(",").foreach( code =>
      ratings(code.charAt(0).toString) = code.drop(2).toInt
    )
    Part(ratings)
  ).toList


def executeWorkflow(workflows: mutable.HashMap[String,Workflow], workflowName:String, part: Part): Unit =
  val workflowRules = workflows(workflowName).rules
//  println()
//  println(f"processing workflow $currentRuleName with rules $workflowRules")

  val totalRules = workflowRules.length
  val fallbackRule = workflowRules.last

  // iterate through each of the workflow rules
  for (i <- 0 until totalRules-1) {
    val rule = workflowRules(i) // "a<3475:A"
//    println(f"executing $rule")
    val ruleCategory = rule.charAt(0).toString //"a"
    val partValue = part.ratings(ruleCategory) // 787

//    println(code)
//    println(codeValue)

    if rule.contains(">") then
      val ruleValue = rule.split(">")(1).split(":")(0).toInt // 3475
      val ruleAction = rule.split(">")(1).split(":")(1) // A

//      println(ruleValue)
//      println(ruleAction)
      if moreThanFunction(partValue, ruleValue) then
//        println(f"$code = $codeValue and is greater than the rule value $ruleValue so execute $ruleAction")
        if ruleAction == "A" then
//          println(f"Added accepted part $part")
          acceptedParts.append(part)
//          acceptedParts += part.totalRating
          return

        if ruleAction == "R" then
//          println(f"Added rejected part $part")
//          rejectedParts.append(part)
          return

//        println(f"execute action: $ruleAction")
        executeWorkflow(workflows, ruleAction, part)
        return

    if rule.contains("<") then
      val ruleValue = rule.split("<")(1).split(":")(0).toInt
      val ruleAction = rule.split("<")(1).split(":")(1)

//      println(ruleValue)
//      println(ruleAction)
      if lessThanFunction(partValue, ruleValue) then
//        println(f"$code = $codeValue and is less than the rule value $ruleValue, so execute  $ruleAction")
        if ruleAction == "A" then
//          println(f"Added accepted part $part")
          acceptedParts.append(part)
//          acceptedParts += part.totalRating
          return

        if ruleAction == "R" then
//          println(f"Added rejected part $part")
//          rejectedParts.append(part)
          return

//        println(f"execute action: $ruleAction")
        executeWorkflow(workflows, ruleAction, part)
        return
  }

//  println(f"all rules failed, run the default action: $defaultSection")
  // if we reached here apply the fallback which could be A, R or another workflow
  if fallbackRule == "A" then
//    println(f"Added accepted part $part")
    acceptedParts.append(part)
//    acceptedParts += part.totalRating
    return

  if fallbackRule == "R" then
//    println(f"Added rejected part $part")
//    rejectedParts.append(part)
    return

  // Fallback isnt A or R so it must be sending it us to another workflow
  executeWorkflow(workflows, fallbackRule, part)


def executeWorkflowWithRange(workflows: mutable.HashMap[String,Workflow], workflowName:String, partRanges: mutable.HashMap[String, Range.Inclusive]): Unit =
//  println()
//  println(f"CURRENT WORKFLOW $workflowName with ranges $partRanges")
  val workflowRules = workflows(workflowName).rules
  val totalRules = workflowRules.length
  val fallbackRule = workflowRules.last

  var updatedPartRangesUpper = partRanges.clone()
  var updatedPartRangesLower = partRanges.clone()
  var rangesForFallback = partRanges.clone()

  for (i <- 0 until totalRules-1) {
    val rule = workflowRules(i) // "a<3475:A"
    val ruleCode = rule.charAt(0).toString //"a"

    val codeRange = rangesForFallback(ruleCode) // this will give range 1...4000 for example

//    println(f"PROCESSING RULE $rule")

    if rule.contains(">") then
      val ruleValue = rule.split(">")(1).split(":")(0).toInt // 3475
      val ruleAction = rule.split(">")(1).split(":")(1) // A

      // split the range into two based on the, so if rule is a>3475, we want range min to 3474 and range 3476 to max range
      //codeRange = a: 1...4000
      val codeRangeMin = codeRange.min  // 1
      val codeRangeMax = codeRange.max  // 4000
      val lowerRange = (codeRangeMin to ruleValue) // 1 .. 3475
      val upperRange = (ruleValue+1 to codeRangeMax) // 3476 to 4000

//      println(f"1) updatedPartRangesLower $updatedPartRangesLower")
//      println(f"2) updatedPartRangesUpper $updatedPartRangesUpper")
//
//      println(f"3) $ruleCode upper range $upperRange  lower range $lowerRange")

      if ruleValue > codeRangeMin && ruleValue < codeRangeMax then
//        println(f"4) updated the upper range for $ruleCode with $upperRange")
        updatedPartRangesUpper(ruleCode) = upperRange

        if ruleValue > codeRangeMin && ruleValue < codeRangeMax then
//        println(f"5) updated the lower range for $ruleCode with $lowerRange")
        updatedPartRangesLower(ruleCode) = lowerRange

      if ruleAction == "A" && ruleValue > codeRangeMin && ruleValue <= codeRangeMax then
//        println(f"6) > REACHED A with upper range $updatedPartRangesUpper")
        acceptedRanges.addOne(updatedPartRangesUpper)

      // we didn't reach a terminal A or R so continue run BFS on both sides of the ranges
      if !"AR".contains(ruleAction) then
//        println(f"7) CALLING NEXT ACTION $ruleAction with $updatedPartRangesUpper")
        executeWorkflowWithRange(workflows, ruleAction, updatedPartRangesUpper)
        updatedPartRangesUpper = updatedPartRangesLower.clone()


      if ruleValue > codeRangeMin && ruleValue <= codeRangeMax then
//        println(f"8) $ruleCode  $ruleValue ($codeRangeMin, $codeRangeMax)")
        rangesForFallback = updatedPartRangesLower.clone()
        updatedPartRangesUpper = updatedPartRangesLower.clone()
//        println(f"9) UPDATED FALLBACK RANGE $rangesForFallback with updatedPartRangesLower")

    if rule.contains("<") then
      val ruleValue = rule.split("<")(1).split(":")(0).toInt
      val ruleAction = rule.split("<")(1).split(":")(1)

      val codeRangeMin = codeRange.min  // 1
      val codeRangeMax = codeRange.max  // 4000
      val lowerRange = (codeRangeMin to ruleValue-1) // 1 .. 3475
      val upperRange = (ruleValue to codeRangeMax) // 3476 to 4000

//      println(f"10) updatedPartRangesLower $updatedPartRangesLower")
//      println(f"11) updatedPartRangesUpper $updatedPartRangesUpper")
//
//      println(f"12) $ruleCode upper range $upperRange  lower range $lowerRange")

      if ruleValue > codeRangeMin && ruleValue < codeRangeMax then
//        println(f"13) updated the upper range for $ruleCode with $upperRange")
        updatedPartRangesUpper(ruleCode) = upperRange

      if ruleValue > codeRangeMin  && ruleValue < codeRangeMax then
//        println(f"14) updated the lower range for $ruleCode with $lowerRange")
        updatedPartRangesLower(ruleCode) = lowerRange

      if ruleAction == "A" && ruleValue >= codeRangeMin && ruleValue < codeRangeMax  then
//        println(f"15) < REACHED A with lower range $updatedPartRangesLower")
        acceptedRanges.append(updatedPartRangesLower)

      // we didn't reach a terminal A or R so continue run BFS on both sides of the ranges
      if !"AR".contains(ruleAction) then
//        println(f"16) CALLING NEXT ACTION $ruleAction with $updatedPartRangesLower")

        executeWorkflowWithRange(workflows, ruleAction, updatedPartRangesLower)
        updatedPartRangesLower = updatedPartRangesUpper.clone()

      if ruleValue >= codeRangeMin && ruleValue < codeRangeMax then
//        println(f"17) $ruleCode  $ruleValue ($codeRangeMin, $codeRangeMax)")
        rangesForFallback = updatedPartRangesUpper.clone()
        updatedPartRangesLower = updatedPartRangesUpper.clone()
//        println(f"18) UPDATED FALLBACK RANGE $rangesForFallback with updatedPartRangesUpper")

  }

  if fallbackRule == "A" then
//    println(f"19) FALLBACK REACHED A with $rangesForFallback")
    acceptedRanges.append(rangesForFallback)
//    return

//  if fallbackRule == "R" then
//    return
  if !"AR".contains(fallbackRule) then
//    println(f"20) FALLBACK CALLING NEXT ACTION $fallbackRule with $rangesForFallback")

    executeWorkflowWithRange(workflows, fallbackRule, rangesForFallback)


def partOne(workflowsRaw: String, partsRaw: String): Long =
  acceptedParts.clear()
//  rejectedParts.clear()

  val workflows = parseWorkflows(workflowsRaw)
//  println(f"Workflows: ${workflows.size}")
//  println(workflows)
//  println()

  val parts = parseParts(partsRaw)
//  println(f"Parts: ${parts.size}")
//  parts.foreach(println)

  parts.foreach(part =>
    executeWorkflow(workflows, "in", part)
  )

//  println(f"Accepted Parts: ${acceptedParts.size}")
//  acceptedParts.foreach(println)
//  println()
//  println(f"Rejected Parts: ${rejectedParts.size}")
//  rejectedParts.foreach(println)

  acceptedParts.toList.map(_.totalRating).sum

def partTwo(workflowsRaw: String): Long =
  acceptedRanges.clear()
  val workflows = parseWorkflows(workflowsRaw)
  val ranges = mutable.HashMap( "x" -> Range.inclusive(1,4000)
    , "m" -> (1 to 4000)
    , "a" -> (1 to 4000)
    , "s" -> (1 to 4000) )
  executeWorkflowWithRange(workflows, "in", ranges)

  println(f"Accepted Ranges: ${acceptedRanges.size}")

  acceptedRanges.map(partsRangeMap =>
//      println(partsRangeMap)
      val products = partsRangeMap.values.map(codeRange =>
        val diff = (codeRange.max - codeRange.min).toLong + 1
//        println(f"$codeRange  DIFF = $diff")

        diff
      ).product
//      println(f"product is $products")
      products
  ).sum
  //  (acceptedParts.toList.map(_.ratings(category)).min,acceptedParts.toList.map(_.ratings(category)).max)


var startTime = System.currentTimeMillis()
partOne(sampleRules, sampleParts)
var timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Sample Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partOne(puzzleRules, puzzleParts)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part One Puzzle Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partTwo(sampleRules)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part Two Sample Input Time Taken: $timeTaken ms")

startTime = System.currentTimeMillis()
partTwo(puzzleRules)
timeTaken = System.currentTimeMillis() - startTime
println(f"Part Two Puzzle Input Time Taken: $timeTaken ms")
