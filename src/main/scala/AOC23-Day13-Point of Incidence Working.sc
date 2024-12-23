import scala.collection.mutable

val sampleInput = "#.##..##.\n..#.##.#.\n##......#\n##......#\n..#.##.#.\n..##..##.\n#.#.##.#.\n\n#...##..#\n#....#..#\n..##..###\n#####.##.\n#####.##.\n..##..###\n#....#..#"

//val sampleInput = "#...##.\n####..#\n....##.\n..#.##.\n#.##..#\n.##....\n...#..#\n..###.#\n#..####\n#...##.\n#...##."
// puzzle pattern 3

val puzzleInput = "...#..##.####.#\n##..##.###..###\n#.#............\n#...#...#..#.#.\n.#..###.#.##.#.\n###.###.##..##.\n.....##........\n##..#....#..#..\n#....#...#..#..\n#..##.#.#.##.#.\n#..##.#.#.##.#.\n#....#...#..#..\n##..#....#..#..\n.....##........\n###.###.##..##.\n\n...#.#.####.#.#\n#..#..##.###..#\n..#.##..##..##.\n##...########..\n.####..####..##\n.##............\n#...#.#.##.#.#.\n.#..#.#.##.#.#.\n.#.##..####..##\n##..####..####.\n##..####..####.\n.#.##..####..##\n.#..#.#.##.#.#.\n#...#.#.##.#.#.\n.##............\n\n#...##.\n####..#\n....##.\n..#.##.\n#.##..#\n.##....\n...#..#\n..###.#\n#..####\n#...##.\n#...##.\n\n.#.#.########\n..#..####..##\n#.#..####..##\n.#.#.########\n...##.#.####.\n.##.##...##..\n.#####.#....#\n....#.#.#..#.\n#..##..##..##\n#...####....#\n###...###..##\n#.##....####.\n#..#.#.......\n##.##..#.##.#\n##.###.......\n\n.#...##\n#..####\n.##....\n..#....\n..#.#..\n#.#.#..\n..#....\n.##....\n#..####\n.#...##\n#..#.##\n#..#...\n..#.###\n..#####\n.###...\n\n.####.##......#\n...##.##..##..#\n...##.##..##..#\n.####.##......#\n#.##.#..#.##.#.\n..#####.##.###.\n.#...#...#..#..\n#######.######.\n.#.#...########\n\n..#..#.##\n##.#####.\n.##.#..##\n...#.##..\n..#...##.\n....##..#\n####.##..\n####.##..\n....##..#\n..#...##.\n...#.##..\n\n#....#.#.#....#.#\n#....###.#....#.#\n.##.#....#.##.#..\n.###.###.#....#.#\n.##.....##....##.\n###.#.#..#.##.#..\n##...#.#.######.#\n##..##.####..####\n#.#..###..#..#..#\n.#####..#.#..#.#.\n.#.##.#..#.##.#..\n\n.##.##.##\n#..####.#\n#..####.#\n.##.##.##\n##.##.###\n.##..###.\n#..#.#...\n\n#...#..#.\n#...#..#.\n.####..#.\n..#..#..#\n...#....#\n##..###..\n#...####.\n#...####.\n##..##...\n...#....#\n..#..#..#\n.####..#.\n#...#..#.\n\n#.##.#..#.##.\n......##.....\n..#.#.##.#.#.\n###.#....#.##\n..#...##...#.\n......##.....\n###.#....#.##\n\n...#..#.....##.##\n...#........##.##\n......###........\n..##....#...#####\n##..###.######.#.\n#.....#..##.###.#\n#.#######.#...##.\n#.###..#.##.##.#.\n..##..#..##.####.\n.#.#..###...##.##\n###..##.###..##.#\n#.##.##.##..##..#\n#.##.##.##..##..#\n\n#..#....#\n#..#....#\n#....##..\n.###..#.#\n.#.##...#\n..#....##\n..#....##\n.#.##...#\n.###..#..\n\n...###...##\n##....#..#.\n###.#.#....\n#..###.##.#\n#..###.##.#\n###.#......\n##....#..#.\n...###...##\n...###...##\n##....#..#.\n###.#......\n\n..#.#.###...##...\n##.#...##.######.\n##.#...##.######.\n#.#.#.###...##...\n.#...#..##.####.#\n.###..#.####..###\n#.##.#.#.#.#..#.#\n\n#..#.#..#......\n.####.....####.\n.#.#####.......\n#.#.#####.####.\n##..#...##.##.#\n...####...####.\n.####.#########\n....#..########\n...#.##...####.\n...#.##...####.\n....#..########\n.###..#########\n...####...####.\n\n##.###.#.\n#.#..#.#.\n...#.#.##\n...#.#.##\n#.#..#.#.\n##.###.#.\n..#....#.\n#..#.####\n..###.#.#\n#####..#.\n..#.####.\n...###.#.\n...###.#.\n..#.####.\n#####..#.\n..###.#.#\n#....####\n\n##..#..#..#\n#...#....#.\n#.......##.\n#.#...##..#\n.#..#...##.\n.##########\n.#....##..#\n.##.###....\n#.###..#..#\n#.###..#..#\n.##.###....\n\n#.#.#.#.##.#.\n.##.###.##.##\n..#...#...##.\n##.#....##...\n##...###..###\n#.##....##...\n#.##....##...\n\n#.####.##..##..\n#.###..##..##..\n#.###..####.###\n.#..#.#...###..\n...##..#..##...\n##..#.#..#.#.##\n.....#.##..#..#\n.##....#.####.#\n###.##.########\n#.....#..#...##\n...##...#####.#\n##....#..##....\n##....#..##....\n...##...#####.#\n#.....#..#...##\n\n##..####..####.\n##...##...####.\n#.##.##.##.##.#\n###.####.######\n.####..####..##\n.#.#...##.#..#.\n#..........##..\n....#..#.......\n.##.#..#.##..##\n#####..########\n...#....#......\n\n###.#.#..#.\n#..##.#####\n.##.###..##\n..#.#.####.\n.#.#...##..\n##...######\n.#.....##..\n.#.....##..\n##...######\n\n..#....#.....\n##########..#\n#........#..#\n..........##.\n#.#....#.####\n#....#...####\n.#.####.#.##.\n#.##..##.####\n..........##.\n\n.#...#..#..\n#..#....#..\n#..#...##..\n##.#..#..##\n.###...####\n#.#.#...#..\n.###.#.#...\n###.#####..\n#..........\n.#....#....\n.#....#.#..\n\n#...##.#...#.##\n##...#.###..###\n#....##..#.###.\n.###..#.##.....\n##.#..##.#.#.#.\n####.#...#.#...\n.#.....#..#...#\n.#.....#..#...#\n####.#...#.#...\n##.#..##.#.#.#.\n.###..#.##....#\n#....##..#.###.\n##...#.###..###\n#...##.#...#.##\n##..#...#.#.#.#\n#...#.##.##....\n#...#.##.##....\n\n#.#..####..#.##.#\n..###....###....#\n.##.#.##.#.##..##\n...########......\n.###.####.###..##\n.###..##..###..##\n###..#..#..######\n...##.##.##......\n.#..##..##..#..#.\n##...####...####.\n..#.#.##.#.#....#\n##..........####.\n..#.######.#....#\n..#.#.####.#....#\n#.#..#..#..#.##.#\n####.#..#.#######\n.#...####...#..#.\n\n..#.##.#...#..#\n.#..##..#.#..#.\n#..####..##.##.\n.#.#..#.#.##...\n###########....\n#.#....#.#..#..\n.###..###.#...#\n##.####.###..#.\n.#..##..#...##.\n#.######.#.#..#\n##..###.####...\n#........##.#.#\n.########.#....\n.########.#....\n#........##.#.#\n\n###...##...##\n#.#.##..##.#.\n#.#.##..##.#.\n###...##...##\n#....####....\n##.##.##.##.#\n.##........##\n.#.#.#..#.#.#\n##..#....#..#\n#..##.##.##.#\n.#.###..###.#\n.##........##\n..#...##...#.\n\n#..#....#..##\n.##.#..#.##..\n...#.##.#....\n##...##...###\n.#..#..#..#..\n#..##..##..##\n.##......##..\n....####...##\n...#.##.#....\n.##..##..##..\n.###.##.###..\n#....##....##\n####....#####\n#.#.####.#.##\n###......####\n....#..#.....\n#.#.#..#.#.##\n\n##.###..#....#..#\n..###..#.###.....\n##.#####...####..\n#...#.#.###..#.##\n#...###.###..#.##\n##.#####...####..\n..###..#.###.....\n##.###..#....#..#\n#.#....##...#####\n#.#....##...#####\n##.###..#....#..#\n\n#..#..#..#..#..\n####..#########\n.##..#.#......#\n#.#..#.#.####.#\n..#...#########\n#..####..#..#..\n..#..##.##..##.\n##...##.#....#.\n##.#.##.#....#.\n\n.#.##.##.#.##..\n###.##.####..#.\n.#.#.#..####.##\n.#.#.#..####.##\n###.##.####..#.\n.#.##.##.#.##..\n...##.###.###.#\n.##....#.###.##\n#..#.#.##.#..#.\n.###.######....\n####...##.#....\n####...##.#.#..\n.###.######....\n\n..##.#.##\n##.#.#.##\n###......\n#..#.##..\n.#..##.##\n..###.#..\n#....#.##\n#..##..##\n##.#..#..\n..#.###..\n..#.##...\n##.#..#..\n#..##..##\n#....#.##\n..###.#..\n\n..#..#.##.#\n.......##..\n####.......\n.#...##..##\n#.#########\n..##.##..##\n#.###......\n\n....####.#.#.##\n.##...##...#.##\n####...###.##..\n#..###....#..#.\n#..###....#..#.\n####...###.#...\n.##...##...#.##\n\n##....#...#\n######..##.\n##.#####.#.\n.......#.#.\n..##......#\n..#........\n####.##.##.\n.....#..###\n...#####.##\n...###.#.##\n.....#..###\n\n##...#.###.\n###.####.#.\n###.#.....#\n...###.#.#.\n...#######.\n##.....###.\n##..##.####\n..####.#...\n#####..#.##\n##.....##.#\n....##..#..\n###..###.#.\n###...##.#.\n\n#...####.##.###\n.#####.#...####\n#.#.#..#.#..##.\n#.#.#..#.#..##.\n.#####.#...####\n....####.##.###\n###..###.###.#.\n..##...#.#..#.#\n#.#.#...###.###\n.###..#...##..#\n######.......#.\n#...#####..##.#\n#...#####..##.#\n######.......#.\n.###..#...##..#\n\n###.#.####.#.\n.#####.##.##.\n#.#..#.###.#.\n#..####.#...#\n#..####.#...#\n#.#..#.###.#.\n.#####.##.##.\n###.#.####.#.\n.##..#.#.#..#\n.##..#.#.#..#\n###.#.####.##\n.#####.##.##.\n#.#..#.###.#.\n\n#.####.####..#.##\n.##..##..#.##.#..\n.........######..\n.##..##.#.####.#.\n#..##..#.#....#.#\n##.##.####....###\n.#.##.#.##....##.\n..####.....##....\n#.#..#.###.##.###\n#......##########\n#......#...##...#\n\n.#..#####.#\n.#.#....#.#\n......##.##\n#.....##.##\n.#.#....#.#\n###.#......\n###.#......\n.#.#....#.#\n#.....##.##\n......##.##\n.#.#....#.#\n\n#.##..##.#...##.#\n#..#..#..##.##.##\n##......##..##..#\n#.##..##.#..#.###\n#.##..##.#..#.###\n##......##..##..#\n#..#..#..##.##.##\n#.##..##.#....#.#\n.###..###..###...\n##.####.##..###.#\n#.#....#.###.###.\n.#......#.#.##...\n##..##..##.###.#.\n\n####...##..#.\n##.#..#......\n##.#.####.###\n...........#.\n.##.##.#####.\n..###..#.#...\n..#..#.##....\n###..##....##\n..##..#.#.###\n..#..#.##.#.#\n..#..#.##.#.#\n\n##.######\n..#.#..#.\n..#..##..\n.#.#.##.#\n##...##..\n..#......\n.##......\n\n#..#.#.#.##\n....#.#..#.\n#..##.#..#.\n#..##.#.##.\n#..##..###.\n#..#..###..\n.##.##..#.#\n.##.##.##.#\n#..#..###..\n\n.#.#..#....\n.#.#..##...\n.#.##...#..\n#...#.#..##\n#...##.####\n..##....###\n#...####.##\n\n####.####.#.###\n####.####.#.###\n..#...#####.##.\n#.#.#...#..#...\n#.###.#.#..#...\n.....##.#######\n.#..###...###.#\n...###.##...#..\n...#.#.##...#..\n\n.....#..###..#.\n##...#...##.##.\n###..#..####...\n##..##....##.##\n##.#..########.\n###...#..#####.\n..##.#..#.#....\n##..####...###.\n###..#...#....#\n####.##.#..##..\n####.####..##..\n###..#...#....#\n##..####...###.\n\n.#.#.##.###.#..\n#..###.....####\n.....##.##.....\n#.#..#...##.#..\n#..####...###..\n..######.#.#...\n.##.#.#..##.#..\n.#...##.#...###\n.#...##.#...###\n.##.#.#..##.#..\n..######.#.#...\n#..####...###..\n#.##.#...##.#..\n\n##..##.\n.....##\n##..##.\n..##...\n##..##.\n.####..\n......#\n##..###\n.####.#\n#....##\n######.\n......#\n#.##.##\n#.##.#.\n#.##.#.\n\n.#.##.#.#.##.##\n##....###..##..\n#.#..#.#..####.\n.######....##..\n#.####.###.##..\n#.####.###.##..\n.######....##..\n#.#..#.#..####.\n##....###..##..\n.#.##.#.#.##.##\n........####...\n#..##..#....#.#\n#......#.##.#..\n##....###.####.\n.#.#..#..#.##..\n\n#..........#.\n.##...##...##\n#.#...##...#.\n...#.#..#.#..\n...###..###..\n.....#..#....\n..##.#..#.##.\n.#..######..#\n.#..######..#\n\n..#..###.....\n..##.###.....\n.....##.#.##.\n.####..#.##..\n.##.#..##...#\n#.#.#...#...#\n......###.##.\n.####..#####.\n#..#.##..#.##\n#..#.##..#.##\n.####..#####.\n......###.##.\n#.#.#...#...#\n\n.#.###.##\n..#.#####\n#.####.##\n#.#.#.##.\n...#..#..\n#..##..##\n##...#.##\n.#...##..\n.#..#..##\n.#..#..##\n.#...##..\n##...#.##\n#..##..##\n\n.#..####...#....#\n.......##...##.##\n.......##...##.##\n.#..####...#....#\n.#.###.###..##..#\n.##.###..........\n#####.#.#.##.###.\n.#.###.#######...\n...##..##.#.##..#\n.###.#.####.#...#\n.###.#.####.#.#.#\n\n.#..#..#..#..#.\n####....#######\n#####..########\n...#....#......\n..##.##.##....#\n#..#....#..##..\n...######......\n.###....###...#\n.#..####..#..#.\n\n..##......#.#\n###.###..#..#\n######.#.#..#\n######..##.##\n#....#..##.#.\n.####.#....#.\n..##..####..#\n##..####.##..\n##..####.##..\n\n..#.##..##.\n....#....#.\n.##..#..#..\n#..#..##..#\n.##..####..\n.##..#..#..\n#..###..###\n.##.#.##.#.\n#..##....##\n\n##.##.###\n#.####.##\n...##....\n.##..##..\n...##....\n#.####.##\n#..##..##\n##....###\n#..##..##\n...##....\n#.####.##\n##....###\n.##.###..\n#.####.##\n#..##..##\n#......##\n..#..#...\n\n.####.###..#.\n#....#...#.##\n#....###.##.#\n......#####..\n......#.###.#\n.#..#..#.##..\n..##..##.##.#\n......##.#.#.\n..#......##.#\n######...####\n.........####\n#.##.#.##.#..\n#.##.#.##.#..\n.........####\n######...####\n\n..##.###.#.\n###.###.##.\n.#.##.##...\n.#.##.##...\n###.###.##.\n..##.###.#.\n###..##...#\n...#.###.#.\n#.##.##..#.\n..#.....#..\n##.....####\n.#.###..###\n####..#..##\n####..#..##\n.#.###..##.\n\n##..#..#....#\n#.###.#.###..\n#.#..#.#...#.\n####.#..###..\n.#..##.#.#..#\n.#....#######\n..#.####.##.#\n..#.####.##.#\n.#....#######\n.#..##.#.#..#\n####.#..###..\n#.#..#.#...#.\n#.##..#.###..\n##..#..#....#\n##..#..#....#\n\n##..#.##.##\n##.##.#.#..\n#.#.#######\n.##....#.#.\n#.###..##.#\n#.###..##.#\n.##....#.#.\n#.#.#######\n##.##.#.#..\n##..#.##..#\n..#..###.#.\n#.##.#.#.##\n#.##.#.#.##\n..#..###.#.\n##..#.##..#\n\n#.#............\n...##.##..##..#\n.#..###.##.###.\n####.#.#..#.#.#\n..#.##......##.\n#..#.#......#.#\n..##.#......#.#\n.#.#....##....#\n#####........##\n#..#..##..##..#\n#..#..##..##..#\n#####........##\n.#.#....##....#\n..##.#......#.#\n#..#.#......#.#\n\n##.##.#.##.#..#\n.##.#.#.#.###.#\n....#.#......##\n....#.#......##\n.##.#.#.#.###.#\n##.##.#.##.#..#\n#..##..#....#.#\n.###.#####...#.\n.###.#####...#.\n...##..#....#.#\n##.##.#.##.#..#\n\n#.##.###.\n.##.##...\n.##.##...\n#.##.###.\n....#.###\n##..#..##\n..##.#.#.\n...#.##.#\n..#######\n..######.\n...#.##.#\n\n.#.#.####.....#\n#....#....#.#.#\n.#####.#.#..#.#\n...#..###...###\n..##...#.######\n###.#####..####\n....#....####.#\n....#....####.#\n###.#####..####\n..##...#.######\n...#..###...###\n.#####.#.#..#.#\n#....#....#.#.#\n.#.#.####.....#\n..##....#....##\n##..#..#...###.\n##..#..#...#.#.\n\n##.########\n##.########\n####.#..#.#\n.#..##.###.\n.##.######.\n#..#......#\n.#####..###\n.###......#\n.#.#.####.#\n.....####..\n.....#..#..\n##..#.##.#.\n.#...####..\n\n.....###.\n...#.##..\n.....###.\n.....###.\n...#.##..\n.....###.\n####.....\n#...###.#\n#...###.#\n####..#..\n.....###.\n\n##....###\n.#....#..\n#..##..#.\n##.##.#.#\n#.#..#.#.\n.##..##..\n#..##..#.\n.######.#\n##.##.##.\n..#..#..#\n##....###\n##....##.\n#.####.#.\n#.####.#.\n#.####.#.\n\n.##..#.##.#..\n#.###.#..#.##\n......####...\n#......##....\n.#.#.#....#..\n..#.#.####.#.\n####..####..#\n#.#..#....#..\n..#...####...\n..#...####...\n#.#..#....#..\n####..####..#\n..#.#.####.#.\n\n.##.#..#..##.##.#\n.###.#...###.##.#\n.###...#.....##..\n.###..##.....##..\n.###.#...###.##.#\n.##.#..#..##.##.#\n..####....#......\n###...##..#..##..\n#...#...####.##.#\n.####.#.###..##..\n##.#####..###..##\n\n###.#.##.....\n.##...##..###\n.##...##..###\n###.#.##.....\n.....###.##..\n##...###.#...\n#####.#......\n.##.#..##.##.\n.##.#..##.##.\n#####.#..#...\n##...###.#...\n.....###.##..\n###.#.##.....\n\n...##.##.#.\n####..##...\n.##.##..#..\n.##...#.#.#\n#..#.#...#.\n##.#.#.#...\n#.......##.\n#........#.\n##.#.#.#...\n####.##...#\n#.##.#.##..\n#.##.#.##..\n####.##...#\n##.#.#.#...\n#........#.\n#.......##.\n##.#.#.#...\n\n#.##.#.#.##.#.#.#\n.......##..##....\n########.##.#####\n.#..#.##....##.#.\n.####..##..##..##\n#######......####\n......########...\n#.##.#.#.##.###.#\n........#..#.....\n..##..#.#..#.#..#\n.####..######..##\n#.##.###....###.#\n.#..#..........#.\n..##...#.##.#...#\n......#......#...\n\n####..#..######\n#.#.#.##.##.##.\n...###.#.#.....\n...###.#.#.....\n#.#.#.#####.##.\n####..#..######\n.##.#...##.#.##\n..###.####.##..\n#...##...#..#.#\n.#.#..#.#######\n......##.###..#\n####...#.#####.\n....###.#..#...\n..####.########\n..####.########\n\n.#####.#..#.###\n..#.....##.....\n######.####.###\n##.##..####..##\n##.##..####..##\n######.####.###\n..#.....##.....\n.#####.#..#.###\n.##############\n.#..#...##...#.\n...###.#.##.###\n.##.#.#....#.#.\n#####...##...##\n\n#...#..####\n#.#.#...##.\n..##.###..#\n#.#..#.####\n##.#.#..##.\n##.#.#..##.\n#.#..######\n..##.###..#\n#.#.#...##.\n\n######.##.##.\n...##.....##.\n##....##.##..\n.######.#..#.\n#.#..#.#.##..\n.######.#.#..\n#......##.###\n###..###.....\n###..###.....\n\n#.#########\n####..##..#\n.##########\n#..###..###\n..##..##..#\n....##..##.\n...#..##..#\n\n.##.##..#\n....#.##.\n.##.#.##.\n.....####\n#..###..#\n....#.##.\n.##.#.##.\n.#...#..#\n.....#..#\n####.#..#\n.##.##..#\n#..#.....\n#..##.##.\n.##...##.\n######..#\n####.####\n.##...##.\n\n#####.##...#.\n..#......##..\n.###.#.#.##..\n####...#.##.#\n#...#....#...\n..###.#######\n#.####..###.#\n#.####..###.#\n..###.#######\n#...#....#...\n####...#.##.#\n.###.#.#.##..\n..#......##..\n#####..#...#.\n#####..#...#.\n\n..#.###.##..#\n######.#.#.#.\n######.#.#.#.\n..#.###.##..#\n#...#..###.#.\n############.\n..##.####...#\n#####.###....\n#...#####....\n##..#......#.\n##..#......#.\n#...#####....\n#####.###....\n..##.####...#\n############.\n#...#..###.##\n..#.###.##..#\n\n#.#..####\n.##.#####\n##.#.#...\n##.#.#...\n.##.#####\n#....####\n##..#.#..\n\n#####.#..\n#.#.#####\n..##.##..\n.....#.##\n..#####.#\n..#####.#\n.....#.##\n\n#..##.##.\n###.#.###\n#..####.#\n.##...#.#\n....##...\n....#.##.\n#..##..##\n....####.\n.##...#.#\n.##...#.#\n....####.\n#..##..##\n....#.##.\n\n##..####..##..##.\n.#..#..#...#..#..\n##..##...##.##.##\n##..###.#..####..\n.#..#......#..#..\n.......#.##.##.##\n.......###......#\n#######.###.##.##\n#....##.##......#\n##..###.#........\n##..###..#.####.#\n.#..#.#.#.......#\n##..#####..#..#..\n......##.########\n..##....#.######.\n\n.......#.#.#..#..\n.####.#.##.#..#..\n######.#####.#.##\n######.#####.#.##\n.####.#.##.#..#..\n.......#.#.#..#.#\n##..##..#.#..##..\n#.##.#.#..#..#.##\n.#..#.##..###...#\n\n#.#......\n...##..##\n.##.####.\n#..#....#\n#..#....#\n.##.####.\n#..##..##\n\n.#..#..\n#....##\n#....##\n.#..#..\n..##...\n..##..#\n#.##.##\n#....#.\n##..##.\n#....#.\n##...##\n\n##.###...\n..#.#...#\n####.###.\n##.#.##.#\n..#...#.#\n####..#..\n.......##\n...#.#...\n####.#...\n...#.#..#\n..#..#...\n....#.#.#\n..###..##\n..##.....\n..##.....\n..###..#.\n....#.#.#\n\n##.#.#.#.###...#.\n.##.#...#.###.#..\n###.######..#....\n###.######..#....\n.##.#...#.###.#..\n##.#.#.#.###...#.\n.##.#####.##..#..\n..##..###.#..#.##\n###..####.##.#..#\n###..####.##.#..#\n..##..###.##.#.##\n\n#....#.##\n#....#.#.\n.#..#.###\n..##..#.#\n#....##.#\n#.##.#...\n#.##.#..#\n.......#.\n##..####.\n\n##.#..#.##.....\n..........##.#.\n.#.#..#.#.##...\n###....########\n.########.###.#\n.##....##.#....\n#.#....#.#.#.##\n#.#....#.#.#.##\n.##....##......\n\n#.#.#.#..#.\n..##.......\n....##.##.#\n##...######\n#####.####.\n###..##..##\n.....######\n\n.....##......\n##..####.####\n..#..##..#...\n..#.####.#...\n#..#....#..##\n##...##...###\n.#..####..#..\n#.#......#.##\n.#.#.##.#.#..\n..##....##...\n##.##..##.###\n\n########.\n......###\n.####.##.\n.#..#.##.\n....#.###\n#######..\n......###\n##..##.##\n.#..#.#..\n.#..#.#..\n##..##.##\n\n##.#......#.##.\n###........####\n###..#..#..####\n.###..##..###.#\n.#.###..###...#\n.....####.....#\n#.###.##.###.##\n#............#.\n..###.##.###..#\n##.#.#..#.#.###\n...#..##..#....\n##.#.####.#.##.\n###.#.##.#.###.\n....######.....\n####......#####\n####......#####\n....######.....\n\n.....######..##\n######.....##..\n..###.##..####.\n.#..###.###..##\n#..###..#######\n.##..##.#.#..#.\n.##.###.#.#..#.\n\n#..#..#\n######.\n.....#.\n#..####\n.##....\n....###\n#..##.#\n#..###.\n####.#.\n.##.#.#\n#..#.#.\n....###\n.###.#.\n.##..#.\n.##..#."

def parse(line: String): (String, List[Int]) =
  val (s"$input $mask") = line: @unchecked
  (input, mask.split(',').map(_.toInt).toList)

def mostFrequentElement(list: List[Int]) : Int =
  list.groupBy(identity).maxBy(_._2.size)._1

def findReflection(pattern:String): Int =
  // reflection must be to the edge
  // find potential reflection points using first line
  val rows = pattern.linesIterator.toList
  val patternWidth = rows(0).length
  println("pattern width: " + patternWidth)

  var reflectionPoints = mutable.Queue[Int]()
  for (rowIdx <- 0 until rows.length)
    val midPoint = Math.ceil(patternWidth.toDouble/2).toInt
      println(f"\nscanning row $rowIdx")
//    println("mid point: " + midPoint)

    for (colIdx <- 1 until patternWidth)
      println(f"\nscanning col $colIdx")

      if (colIdx < midPoint) then
        val endIdx = colIdx + colIdx
        val leftHalf = rows(rowIdx).substring(0, colIdx)
        val rightHalf = rows(rowIdx).substring(colIdx, endIdx)

        println(f"left scan colIdx $colIdx / midPoint $midPoint / leftHalf $leftHalf / rightHalf $rightHalf")

        if (leftHalf == rightHalf.reverse) then
          println("reflection found")
          reflectionPoints.enqueue(colIdx)
//        else
//          reflectionPoint = 0 // i.e. not found

      else
        val startIdx = colIdx - (patternWidth - colIdx)
        val leftHalf = rows(rowIdx).substring(startIdx, colIdx)
        val rightHalf = rows(rowIdx).substring(colIdx)

        println(f"right scan colIdx $colIdx / midPoint $midPoint / leftHalf $leftHalf / rightHalf $rightHalf")

        if (leftHalf == rightHalf.reverse) then
          println("reflection found")
          reflectionPoints.enqueue(colIdx)
//        else
//          reflectionPoint = 0 // i.e. not found

  println("reflectionPoints: " + reflectionPoints.toList )


  val mostFrequent = mostFrequentElement(reflectionPoints.toList)
  println("mostFrequent: " + mostFrequent + " with count " + reflectionPoints.count(_ == mostFrequent) + " and needs to match " + rows.size)

  // make sure that the most frequent reflection index is same for every row
  if(reflectionPoints.count(_ == mostFrequent) == rows.size) then
    println("REFLECTION FOUND")
    mostFrequent
  else
    println("REFLECTION NOT FOUND")
    0




def solution(input: String): Int =
  val scores = input.split("\n\n").zipWithIndex.map {
    case (pattern, idx) =>
      println(f"Pattern ${idx+1}")
      // try vertical scan first
      val verticalReflectionIdx = findReflection(pattern)

      // then try horizontal scan
      val transposedPatten = pattern.linesIterator.toList.transpose.map(_.mkString(""))
      println(transposedPatten.mkString("\n"))
      val horizontalReflectionIdx = findReflection(transposedPatten.mkString("\n"))

      val score = verticalReflectionIdx + (horizontalReflectionIdx * 100)
      score

  }.toList

  println("Scores: " + scores.mkString("Array(", ", ", ")"))
  println(f"Total score: ${scores.sum}")
  scores.sum



var startTime = System.currentTimeMillis()
solution(sampleInput)
var timeTaken = System.currentTimeMillis() - startTime
println(f"Time taken: $timeTaken ms")

startTime = System.currentTimeMillis()
solution(puzzleInput)
timeTaken = System.currentTimeMillis() - startTime
println(f"Time taken: $timeTaken ms")



//"123##32131".zipWithIndex.filter(pair => pair._1 == "##").map(pair => pair._2).toList

val string = "1##23##32131"
val re = "##".r
re.findAllIn(string).toList
string.zipWithIndex


"123456789".substring(0,1)
"123456789".substring(1,2)

List(1,1,1,3).groupBy(identity).maxBy(_._2.size)