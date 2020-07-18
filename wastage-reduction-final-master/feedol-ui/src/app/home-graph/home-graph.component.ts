import { Component, OnInit } from '@angular/core';
import * as CanvasJS from '../../assets/js/canvasjs.min';
@Component({
  selector: 'app-home-graph',
  templateUrl: './home-graph.component.html',
  styleUrls: ['./home-graph.component.css']
})
export class HomeGraphComponent implements OnInit {
  ngOnInit() {
    var chart = new CanvasJS.Chart("chartContainer", {
      animationEnabled: true,
      theme: "dark",
      // "light1", "light2", "dark1", "dark2"
      backgroundColor: "rgba(225,150,150,0.5)",
      title:{
        text: "Donation Analysis"
      },
      axisY: {
        title: "Reserves(MMbbl)"
      },
      data: [{        
        type: "column",  
        showInLegend: true, 
        legendMarkerColor: "grey",
        // legendText: "MMbbl = one million barrels",
        dataPoints: [      
          { y: 300878, label: "Kerala" },
          { y: 266455,  label: "Odisha" },
          { y: 169709,  label: "Maharashtra" },
          { y: 158400,  label: "Tamil Nadu" },
          { y: 142503,  label: "Andhra Pradesh" },
          { y: 101500, label: "Karnataka" },
          { y: 97800,  label: "Gujarat" },
          { y: 80000,  label: "Delhi" }
        ]
      }]
    });
    chart.render();
  }

}
