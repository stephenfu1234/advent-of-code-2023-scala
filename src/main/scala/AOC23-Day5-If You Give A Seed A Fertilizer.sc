val sampleSeedsRaw = "79 14 55 13"
val sampleSeedToSoilMapRaw = "50 98 2\n52 50 48"
val sampleSoilToFertilizerMapRaw = "0 15 37\n37 52 2\n39 0 15"
val sampleFertilizerToWaterMapRaw = "49 53 8\n0 11 42\n42 0 7\n57 7 4"
val sampleWaterToLightMapRaw = "88 18 7\n18 25 70"
val sampleLightToTemperatureMapRaw = "45 77 23\n81 45 19\n68 64 13"
val sampleTemperatureToHumidityMapRaw = "0 69 1\n1 0 69"
val sampleHumidityToLocationMapRaw = "60 56 37\n56 93 4"

case class Mapping(startSource: Long, endSource: Long, startDestination: Long, endDestination: Long, range: Long)


def calculateMapping(rawMappings: String, source: Long): Long =
  val mappings = rawMappings.linesIterator.map(line =>
    val values = line.split(" ").map(_.toLong)
    Mapping(startSource = values(1),
      endSource = values(1) + values(2) - 1,
      startDestination = values(0),
      endDestination = values(0) + values(2) - 1,
      range = values(2))
  ).toList

  val detectedMappings = mappings.map( mapping =>
    if (source >= mapping.startSource && source <= mapping.endSource)
      source - mapping.startSource + mapping.startDestination
    else
      -1
  ).filter(_>=0)

  if (detectedMappings.isEmpty) // if no mappings found then default to source
    source
  else // else we found mappings so take the head as there will only be 1 mapping
    detectedMappings.head

def solution(input : String,
             seedToSoilMapRaw: String,
             soilToFertilizerMapRaw: String,
             fertilizerToWaterMapRaw: String,
             waterToLightMapRaw: String,
             lightToTemperatureMapRaw: String,
             temperatureToHumidityMapRaw: String,
             humidityToLocationMapRaw: String
            ) =
  input.split(" ").map(_.toLong).map(
    calculateMapping(seedToSoilMapRaw, _)
  ).map(
    calculateMapping(soilToFertilizerMapRaw, _)
  ).map(
    calculateMapping(fertilizerToWaterMapRaw, _)
  ).map(
    calculateMapping(waterToLightMapRaw, _)
  ).map(
    calculateMapping(lightToTemperatureMapRaw, _)
  ).map(
    calculateMapping(temperatureToHumidityMapRaw, _)
  ).map(
    calculateMapping(humidityToLocationMapRaw, _)
  )

def calculateReverseMapping(rawMappings: String, source: Long): Long =
  val mappings = rawMappings.linesIterator.map(line =>
    val values = line.split(" ").map(_.toLong)
    Mapping(startSource = values(0),
      endSource = values(0) + values(2) - 1,
      startDestination = values(1),
      endDestination = values(1) + values(2) - 1,
      range = values(2))
  ).toList

  val detectedMappings = mappings.map( mapping =>
    if (source >= mapping.startSource && source <= mapping.endSource)
      source - mapping.startSource + mapping.startDestination
    else
      -1
  ).filter(_>=0)

  if (detectedMappings.isEmpty) // if no mappings found then default to source
    source
  else // else we found mappings so take the head as there will only be 1 mapping
    detectedMappings.head

def reverseSolution(input : String,
             seedToSoilMapRaw: String,
             soilToFertilizerMapRaw: String,
             fertilizerToWaterMapRaw: String,
             waterToLightMapRaw: String,
             lightToTemperatureMapRaw: String,
             temperatureToHumidityMapRaw: String,
             humidityToLocationMapRaw: String
            ) =
  input.split(" ").map(_.toLong).map(
    calculateReverseMapping(humidityToLocationMapRaw, _)
  ).map(
    calculateReverseMapping(temperatureToHumidityMapRaw, _)
  ).map(
    calculateReverseMapping(lightToTemperatureMapRaw, _)
  ).map(
    calculateReverseMapping(waterToLightMapRaw, _)
  ).map(
    calculateReverseMapping(fertilizerToWaterMapRaw, _)
  ).map(
    calculateReverseMapping(soilToFertilizerMapRaw, _)
  ).map(
    calculateReverseMapping(seedToSoilMapRaw, _)
  )
//calculateMapping(sampleSeedToSoilMapRaw, 82)
//calculateMapping(sampleSoilToFertilizerMapRaw, 84)
//calculateMapping(sampleFertilizerToWaterMapRaw, 84)
//calculateMapping(sampleWaterToLightMapRaw, 84)
//calculateMapping(sampleWaterToLightMapRaw, 77)
//calculateMapping(sampleLightToTemperatureMapRaw, 45)
//calculateMapping(sampleHumidityToLocationMapRaw, 46)

solution(sampleSeedsRaw,
  sampleSeedToSoilMapRaw,
  sampleSoilToFertilizerMapRaw,
  sampleFertilizerToWaterMapRaw,
  sampleWaterToLightMapRaw,
  sampleLightToTemperatureMapRaw,
  sampleTemperatureToHumidityMapRaw,
  sampleHumidityToLocationMapRaw)

solution(sampleSeedsRaw,
  sampleSeedToSoilMapRaw,
  sampleSoilToFertilizerMapRaw,
  sampleFertilizerToWaterMapRaw,
  sampleWaterToLightMapRaw,
  sampleLightToTemperatureMapRaw,
  sampleTemperatureToHumidityMapRaw,
  sampleHumidityToLocationMapRaw).min

reverseSolution("82 43 86 35",
  sampleSeedToSoilMapRaw,
  sampleSoilToFertilizerMapRaw,
  sampleFertilizerToWaterMapRaw,
  sampleWaterToLightMapRaw,
  sampleLightToTemperatureMapRaw,
  sampleTemperatureToHumidityMapRaw,
  sampleHumidityToLocationMapRaw)

reverseSolution("82 43 86 35",
  sampleSeedToSoilMapRaw,
  sampleSoilToFertilizerMapRaw,
  sampleFertilizerToWaterMapRaw,
  sampleWaterToLightMapRaw,
  sampleLightToTemperatureMapRaw,
  sampleTemperatureToHumidityMapRaw,
  sampleHumidityToLocationMapRaw).min

val puzzleSeedsRaw = "2276375722 160148132 3424292843 82110297 1692203766 342813967 3289792522 103516087 2590548294 590357761 1365412380 80084180 3574751516 584781136 4207087048 36194356 1515742281 174009980 6434225 291842774"
val puzzleSeedToSoilMapRaw = "4170452318 3837406401 124514978\n2212408060 1593776674 105988696\n3837406401 4016132523 278834773\n1475766470 1699765370 492158296\n3698488336 1475766470 118010204\n2318396756 2191923666 46351359\n4116241174 3961921379 54211144\n2193579298 3791037069 18828762\n2364748115 2578360543 354997036\n3085506703 3439828590 106510622\n1967924766 3546339212 219021823\n2719745151 3765361035 25676034\n2745421185 2238275025 340085518\n2186946589 3809865831 6632709\n3192017325 2933357579 506471011"
val puzzleSoilToFertilizerMapRaw = "2067774073 3521970321 52706909\n3338663639 285713733 377282283\n4175452431 2125409520 119514865\n3950920796 1900877885 224531635\n285713733 3604616580 690350716\n976064449 3368036703 153933618\n2120480982 662996016 210956413\n2763248642 1355402238 545475647\n3715945922 873952429 49638562\n3765584484 3182700391 185336312\n2331437395 923590991 431811247\n1129998067 2244924385 937776006\n3308724289 3574677230 29939350"
val puzzleFertilizerToWaterMapRaw = "1898912715 0 159034880\n0 781591504 125461131\n4234890433 2427770485 8749678\n176481534 1845116986 384152450\n822014814 539693831 241897673\n125461131 907052635 47763268\n1476125220 244008638 19613711\n3828547378 4170474998 124492298\n2643114268 2457193301 126243103\n173224399 2229269436 3257135\n2916187764 3376015556 236473226\n764735505 186729329 57279309\n2427770485 3802085897 160735547\n2895514626 2436520163 20673138\n3152660990 2671736916 584987016\n1495738931 1131222975 403173784\n1339983969 1534396759 136141251\n2588506032 3612488782 54608236\n3737648006 2583436404 88300512\n737041056 159034880 27694449\n2057947595 1677521625 167595361\n1063912487 263622349 276071482\n3953039676 4041226796 129248202\n2225542956 1670538010 6983615\n560633984 954815903 176407072\n2847762723 3328263653 47751903\n2769357371 3962821444 78405352\n3825948518 3256723932 2598860\n4082287878 3667097018 134988879\n4243640111 3276936468 51327185\n4217276757 3259322792 17613676"
val puzzleWaterToLightMapRaw = "527906959 2908176499 284796856\n1306013866 0 139756297\n500839409 1466481782 27067550\n1269694476 139756297 36319390\n0 778456518 2402633\n4218077327 4154765934 76889969\n812703815 4004150799 56130996\n153843304 3657154694 8975056\n2402633 905946004 132694584\n3795108796 2776082693 132093806\n3927202602 1422228955 44252827\n1445770163 1493549332 1282533361\n3794865694 780859151 243102\n2728303524 176075687 602380831\n162818360 3666129750 338021049\n3330684355 3319846298 337308396\n4154765934 4231655903 63311393\n135097217 887199917 18746087\n3667992751 3192973355 126872943\n3971455429 781102253 88826366\n1252423178 869928619 17271298\n868834811 1038640588 383588367"
val puzzleLightToTemperatureMapRaw = "2621973104 3678827401 230150807\n1333642604 1531317439 615453278\n3364444750 2854318675 314483239\n2978187907 3908978208 107198609\n1117308885 1110453605 216333719\n1951157390 4016176817 152726483\n4168382203 2717095112 26843204\n0 312822387 5553076\n287414983 245463475 67358912\n1949095882 2597527252 2061508\n3836867339 1522015715 9301724\n648138229 2599588760 117506352\n4132690450 1486323962 35691753\n2852123911 4168903300 126063996\n2468610361 3525464658 153362743\n526108840 988424216 122029389\n5553076 0 148736111\n3265904462 1326787324 98540288\n4195225407 716774234 17303853\n181751976 318375463 105663007\n843084177 3275513023 249951635\n2214264232 734078087 254346129\n154289187 218000686 27462789\n3146382866 684048190 32726044\n765644581 2433292104 77439596\n3179108910 2510731700 86795552\n3846169063 2146770717 286521387\n2103883873 2743938316 110380359\n3085386516 1425327612 60996350\n3678927989 526108840 157939350\n4212529260 3193074987 82438036\n354773895 148736111 69264575\n1093035812 3168801914 24273073"
val puzzleTemperatureToHumidityMapRaw = "1008510114 1939290935 27755995\n2205283444 4197517502 16218189\n1119061522 3123774174 108864966\n1566495924 221087407 33939034\n3089618547 3728555042 25452278\n2341294643 3455988869 16076350\n2286651827 3754007320 54642816\n704748216 2542375745 76754089\n445299830 3938069116 259448386\n1036266109 1300576315 82795413\n178337856 1565003866 40230920\n2122934367 1605234786 81339593\n1484902828 980285858 81593096\n2823460240 1967046930 266158307\n3827446421 1526750766 38253100\n984919715 1161567987 23590399\n218568776 1061878954 99689033\n4049237602 3232639140 223349729\n953670836 2233205237 3881060\n318257809 3472065219 89705062\n1727156113 3113814046 9960128\n3733360236 444372828 94086185\n4272587331 3688491436 22379965\n910921285 178337856 42749551\n781502305 3808650136 129418980\n957551896 2798966448 27367819\n1870217811 1686574379 252716556\n407962871 2998327877 37336959\n2508087592 2826334267 171993610\n1600434958 3561770281 126721155\n3865699521 812829188 167456670\n1737116241 1185158386 115417929\n1852534170 3710871401 17683641\n3420360273 255026441 38629788\n1227926488 2620139318 178827130\n4033156191 4250190027 16081411\n2204273960 2619129834 1009484\n2250197491 4213735691 36454336\n2680081202 1383371728 143379038\n3458990061 538459013 274370175\n3115070825 2237086297 305289448\n2357370993 293656229 150716599\n1406753618 3035664836 78149210\n2221501633 4266271438 28695858"
val puzzleHumidityToLocationMapRaw = "2849843584 4147982382 56632112\n3849085050 3618212322 355529444\n1632881348 407047779 65646492\n3056274757 2246063521 686771203\n2729873863 4028012661 26534599\n3779070915 1543896540 70014135\n2571854216 2932834724 91402738\n2192942437 1028113266 378911779\n2960746591 932585100 95528166\n765942740 0 407047779\n2663256954 1441254676 66616909\n2756408462 4054547260 93435122\n1698527840 1407025045 34229631\n0 3024237462 156854744\n3743045960 1507871585 36024955\n156854744 3181092206 437120116\n1172990519 472694271 459890829\n2906475696 3973741766 54270895\n593974860 2074095641 171967880\n1732757471 1613910675 460184966"

solution(puzzleSeedsRaw,
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min

def pairs[A](as: List[A]) = as.grouped(2).map {
  case List(x, y) => (x, y)
  case _ => sys.error("uneven size")
}.toList

def solution2(batchSize: Int, input : String,
             seedToSoilMapRaw: String,
             soilToFertilizerMapRaw: String,
             fertilizerToWaterMapRaw: String,
             waterToLightMapRaw: String,
             lightToTemperatureMapRaw: String,
             temperatureToHumidityMapRaw: String,
             humidityToLocationMapRaw: String
            ) =

//  pairs(input.split(" ").map(_.toLong).toList).map(
//    pair => pair._1 //+ pair._2 - 1
//  )
  pairs(input.split(" ").map(_.toLong).toList).flatMap(seedRange =>
//    (seedRange._1 until seedRange._1 + seedRange._2 - 1).toList
    (seedRange._1 to seedRange._1 + seedRange._2 - 2 by batchSize).toList
  ).map(
    calculateMapping(seedToSoilMapRaw, _)
  ).map(
    calculateMapping(soilToFertilizerMapRaw, _)
  ).map(
    calculateMapping(fertilizerToWaterMapRaw, _)
  ).map(
    calculateMapping(waterToLightMapRaw, _)
  ).map(
    calculateMapping(lightToTemperatureMapRaw, _)
  ).map(
    calculateMapping(temperatureToHumidityMapRaw, _)
  ).map(
    calculateMapping(humidityToLocationMapRaw, _)
  )

//solution2(sampleSeedsRaw,
//  sampleSeedToSoilMapRaw,
//  sampleSoilToFertilizerMapRaw,
//  sampleFertilizerToWaterMapRaw,
//  sampleWaterToLightMapRaw,
//  sampleLightToTemperatureMapRaw,
//  sampleTemperatureToHumidityMapRaw,
//  sampleHumidityToLocationMapRaw)

//solution2(1, sampleSeedsRaw,
//  sampleSeedToSoilMapRaw,
//  sampleSoilToFertilizerMapRaw,
//  sampleFertilizerToWaterMapRaw,
//  sampleWaterToLightMapRaw,
//  sampleLightToTemperatureMapRaw,
//  sampleTemperatureToHumidityMapRaw,
//  sampleHumidityToLocationMapRaw).min

val startTimeMs = System.currentTimeMillis()
//solution2(100, puzzleSeedsRaw,
solution2(1, "3424292843 12110297",
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min
//
solution2(1, "3436403140 10000000",
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min

solution2(1, "3446403140 10000000",
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min

solution2(1, "3456403140 10000000",
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min


solution2(1, "3466403140 10000000",
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min


solution2(1, "3476403140 10000000",
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min


solution2(1, "3486403140 10000000",
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min


solution2(1, "3496403140 10000000",
  puzzleSeedToSoilMapRaw,
  puzzleSoilToFertilizerMapRaw,
  puzzleFertilizerToWaterMapRaw,
  puzzleWaterToLightMapRaw,
  puzzleLightToTemperatureMapRaw,
  puzzleTemperatureToHumidityMapRaw,
  puzzleHumidityToLocationMapRaw).min



//solution2("3574751516 584781136",
//  puzzleSeedToSoilMapRaw,
//  puzzleSoilToFertilizerMapRaw,
//  puzzleFertilizerToWaterMapRaw,
//  puzzleWaterToLightMapRaw,
//  puzzleLightToTemperatureMapRaw,
//  puzzleTemperatureToHumidityMapRaw,
//  puzzleHumidityToLocationMapRaw).min
val timeTakenMs = System.currentTimeMillis() - startTimeMs
println("Took " +  (timeTakenMs/1000).toDouble  + "s")

//this will be too slow

// too high 46294428
// too high 46294178
// 46294428 with sample size 1000 2mins
// 46294428 with sample size 500 4.5mins
// 46294178 with sample size 250 9mins
//  with sample size 100 mins


//solution("79 80 81 82 83 84 85 86 87 88 89 90 91 92",
//  sampleSeedToSoilMapRaw,
//  sampleSoilToFertilizerMapRaw,
//  sampleFertilizerToWaterMapRaw,
//  sampleWaterToLightMapRaw,
//  sampleLightToTemperatureMapRaw,
//  sampleTemperatureToHumidityMapRaw,
//  sampleHumidityToLocationMapRaw)

