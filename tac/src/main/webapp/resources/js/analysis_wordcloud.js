// // word cloud test
// kindwordcloudload() {
//     const cloud = require("d3-cloud");
//     cloud()
//       .words(this.words)
//       .size(["1200", "1200"])
//       .padding(1)
//       .font("Impact")
//       // .style("font-family", "RFR")
//       // .rotate 단어돌리기
//       .rotate(function () {
//         // return (~~(Math.random() * 6) - 3) * 1;
//         // if ( d.size > 55920) return 90;
//         // else
//         return 0;
//       })
//       // .style("fill", function (d) {
//       //         if ( d.size > 5920) return ( "#506230" );
//       //           else return ( "#000000");
//       //     })
//       .fontSize(function (d) {
//         return Math.sqrt(d.size) * 0.65;
//       })
//       // .fontSize(function (d) {
//       //       return wordScale(d.frequency);
//       //   })
//       // end는 모든 단어를 다 위치 시킬 때 발생
//       .on("end", this.end)
//       .spiral("archimedean")
//       .start()
//       .stop();
//   },
//   end(words) {
//     const d3 = require("d3");
//     const width = 1200;
//     const height = 1200;
//     d3.select("#kind_wordcloud")
//       .append("svg")
//       .attr("width", width)
//       .attr("height", height)
//       // 출력크기
//       .style("background", "white")
//       .append("g")
//       // g를 중심에서 단어를 그리기 때문에 g를 svg중심으로 이동한다.
//       // .style("font-family", "Impact")
//       .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")")
//       .style("fill", () => {
//         return "#2a2a2a";
//       })
//       .selectAll("text")
//       .data(words)
//       .enter()
//       .append("text")
//       // .style("fill-opacity", .5) // 투명도
//       .style("font-size", (d) => {
//         // if ( d.size)
//         return d.size + "px";
//       })
//       // .style("font-family", "Impact")
//       .attr("text-anchor", "middle")
//       .attr("transform", (d) => {
//         return "translate(" + [d.x, d.y] + ")rotate( " + d.rotate + ")";
//       })
//       .text((d) => d.text);
//   },