<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/TagLib.jspf" %>

<ul class="breadcrumb breadcrumb-page">
	<div class="breadcrumb-label text-light-gray">You are here: </div>
	<li><a href="#">Home</a></li>
	<li class="active"><a href="#">Dashboard</a></li>
</ul>
<div class="page-header">
	
	<div class="row">
		<!-- Page header, center on small screens -->
		<h1 class="col-xs-12 col-sm-4 text-center text-left-sm"><i class="fa fa-dashboard page-header-icon"></i>&nbsp;&nbsp;Dashboard</h1>
	</div>
</div> <!-- / .page-header -->

<div class="row">
<div class="col-md-8">

<!-- 5. $UPLOADS_CHART =============================================================================

Uploads chart
-->
<!-- Javascript -->
<script>
	init.push(function () {
		var uploads_data = [
			{ day: '2014-10-17', v: 0 },
			{ day: '2014-10-18', v: 0 },
			{ day: '2014-10-19', v: 0 },
			{ day: '2014-10-20', v: 0 },
			{ day: '2014-10-21', v: 0  },
			{ day: '2014-10-22', v: 0  },
			{ day: '2014-10-23', v: 1 }
		];
		Morris.Line({
			element: 'hero-graph',
			data: uploads_data,
			xkey: 'day',
			ykeys: ['v'],
			labels: ['Value'],
			lineColors: ['#fff'],
			lineWidth: 2,
			pointSize: 4,
			gridLineColor: 'rgba(255,255,255,.5)',
			resize: true,
			gridTextColor: '#fff',
			xLabels: "day",
			xLabelFormat: function(d) {
				return ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov', 'Dec'][d.getMonth()] + ' ' + d.getDate(); 
			},
		});
	});
</script>
<!-- / Javascript -->

<div class="stat-panel">
	<div class="stat-row">
		<!-- Small horizontal padding, bordered, without right border, top aligned text -->
		<div class="stat-cell col-sm-4 padding-sm-hr bordered no-border-r valign-top">
			<!-- Small padding, without top padding, extra small horizontal padding -->
			<h4 class="padding-sm no-padding-t padding-xs-hr"><i class="fa fa-cloud-upload text-primary"></i>&nbsp;&nbsp;Uploads</h4>
			<!-- Without margin -->
			<ul class="list-group no-margin">
				<li class="list-group-item no-border-hr padding-xs-hr no-bg no-border-radius">
					Course <span class="label label-pa-purple pull-right">2</span>
				</li> <!-- / .list-group-item -->
				<li class="list-group-item no-border-hr padding-xs-hr no-bg">
					Chapters <span class="label label-danger pull-right">4</span>
				</li> <!-- / .list-group-item -->
			</ul>
		</div> <!-- /.stat-cell -->
		<div class="stat-cell col-sm-8 bg-primary padding-sm valign-middle">
			<div id="hero-graph" class="graph" style="height: 230px;"></div>
		</div>
	</div>
</div> <!-- /.stat-panel -->


<!-- 6. $EASY_PIE_CHARTS ===========================================================================

	Easy Pie charts
-->
	<!-- Javascript -->
	<script>
		init.push(function () {
			// Easy Pie Charts
			var easyPieChartDefaults = {
				animate: 2000,
				scaleColor: false,
				lineWidth: 6,
				lineCap: 'square',
				size: 90,
				trackColor: '#e5e5e5'
			}
			$('#easy-pie-chart-1').easyPieChart($.extend({}, easyPieChartDefaults, {
				barColor: PixelAdmin.settings.consts.COLORS[1]
			}));
			$('#easy-pie-chart-2').easyPieChart($.extend({}, easyPieChartDefaults, {
				barColor: PixelAdmin.settings.consts.COLORS[1]
			}));
			$('#easy-pie-chart-3').easyPieChart($.extend({}, easyPieChartDefaults, {
				barColor: PixelAdmin.settings.consts.COLORS[1]
			}));
		});
	</script>
	<!-- / Javascript -->

	<div class="row">
		<div class="col-xs-4">
			<!-- Centered text -->
			<div class="stat-panel text-center">
				<div class="stat-row">
					<!-- Dark gray background, small padding, extra small text, semibold text -->
					<div class="stat-cell bg-dark-gray padding-sm text-xs text-semibold">
						<i class="fa fa-globe"></i>&nbsp;&nbsp;BANDWIDTH
					</div>
				</div> <!-- /.stat-row -->
				<div class="stat-row">
					<!-- Bordered, without top border, without horizontal padding -->
					<div class="stat-cell bordered no-border-t no-padding-hr">
						<div class="pie-chart" data-percent="43" id="easy-pie-chart-1">
							<div class="pie-chart-label">1.2GB</div>
						</div>
					</div>
				</div> <!-- /.stat-row -->
			</div> <!-- /.stat-panel -->
		</div>
		<div class="col-xs-4">
			<div class="stat-panel text-center">
				<div class="stat-row">
					<!-- Dark gray background, small padding, extra small text, semibold text -->
					<div class="stat-cell bg-dark-gray padding-sm text-xs text-semibold">
						<i class="fa fa-flash"></i>&nbsp;&nbsp;최대 CPU
					</div>
				</div> <!-- /.stat-row -->
				<div class="stat-row">
					<!-- Bordered, without top border, without horizontal padding -->
					<div class="stat-cell bordered no-border-t no-padding-hr">
						<div class="pie-chart" data-percent="93" id="easy-pie-chart-2">
							<div class="pie-chart-label">23%</div>
						</div>
					</div>
				</div> <!-- /.stat-row -->
			</div> <!-- /.stat-panel -->
		</div>
		<div class="col-xs-4">
			<div class="stat-panel text-center">
				<div class="stat-row">
					<!-- Dark gray background, small padding, extra small text, semibold text -->
					<div class="stat-cell bg-dark-gray padding-sm text-xs text-semibold">
						<i class="fa fa-cloud"></i>&nbsp;&nbsp;DISK
					</div>
				</div> <!-- /.stat-row -->
				<div class="stat-row">
					<!-- Bordered, without top border, without horizontal padding -->
					<div class="stat-cell bordered no-border-t no-padding-hr">
						<div class="pie-chart" data-percent="75" id="easy-pie-chart-3">
							<div class="pie-chart-label">3.2GB</div>
						</div>
					</div>
				</div> <!-- /.stat-row -->
			</div> <!-- /.stat-panel -->
		</div>
	</div>
</div>
<!-- /6. $EASY_PIE_CHARTS -->

<div class="col-md-4">
	<div class="row">

<!-- 7. $EARNED_TODAY_STAT_PANEL ===================================================================

		Earned today stat panel
-->
		<div class="col-sm-4 col-md-12">
			<div class="stat-panel">
				<!-- Danger background, vertically centered text -->
				<div class="stat-cell bg-danger valign-middle">
					<!-- Stat panel bg icon -->
					<i class="fa fa-trophy bg-icon"></i>
					<!-- Extra large text -->
					<span class="text-xlg"><span class="text-lg text-slim">$</span><strong>0</strong></span><br>
					<!-- Big text -->
					<span class="text-bg">Earned today</span><br>
					<!-- Small text -->
					<span class="text-sm"><a href="#">See details in your profile</a></span>
				</div> <!-- /.stat-cell -->
			</div> <!-- /.stat-panel -->
		</div>
<!-- /7. $EARNED_TODAY_STAT_PANEL -->


<!-- 8. $RETWEETS_GRAPH_STAT_PANEL =================================================================

			Retweets graph stat panel
-->
			<div class="col-sm-4 col-md-12">
				<!-- Javascript -->
				<script>
					init.push(function () {
						$("#stats-sparklines-3").pixelSparkline([0,0,0,0,0,0,0,0,0], {
							type: 'line',
							width: '100%',
							height: '45px',
							fillColor: '',
							lineColor: '#fff',
							lineWidth: 2,
							spotColor: '#ffffff',
							minSpotColor: '#ffffff',
							maxSpotColor: '#ffffff',
							highlightSpotColor: '#ffffff',
							highlightLineColor: '#ffffff',
							spotRadius: 4,
							highlightLineColor: '#ffffff'
						});
					});
				</script>
				<!-- / Javascript -->

				<div class="stat-panel">
					<div class="stat-row">
						<!-- Purple background, small padding -->
						<div class="stat-cell bg-pa-purple padding-sm">
							<!-- Extra small text -->
							<div class="text-xs" style="margin-bottom: 5px;">RETWEETS GRAPH</div>
							<div class="stats-sparklines" id="stats-sparklines-3" style="width: 100%"></div>
						</div>
					</div> <!-- /.stat-row -->
					<div class="stat-row">
						<!-- Bordered, without top border, horizontally centered text -->
						<div class="stat-counters bordered no-border-t text-center">
							<!-- Small padding, without horizontal padding -->
							<div class="stat-cell col-xs-4 padding-sm no-padding-hr">
								<!-- Big text -->
								<span class="text-bg"><strong>0</strong></span><br>
								<!-- Extra small text -->
								<span class="text-xs text-muted">TWEETS</span>
							</div>
							<!-- Small padding, without horizontal padding -->
							<div class="stat-cell col-xs-4 padding-sm no-padding-hr">
								<!-- Big text -->
								<span class="text-bg"><strong>0</strong></span><br>
								<!-- Extra small text -->
								<span class="text-xs text-muted">FOLLOWERS</span>
							</div>
							<!-- Small padding, without horizontal padding -->
							<div class="stat-cell col-xs-4 padding-sm no-padding-hr">
								<!-- Big text -->
								<span class="text-bg"><strong>0</strong></span><br>
								<!-- Extra small text -->
								<span class="text-xs text-muted">FOLLOWING</span>
							</div>
						</div> <!-- /.stat-counters -->
					</div> <!-- /.stat-row -->
				</div> <!-- /.stat-panel -->
			</div>
<!-- /8. $RETWEETS_GRAPH_STAT_PANEL -->

<!-- 9. $UNIQUE_VISITORS_STAT_PANEL ================================================================

			Unique visitors stat panel
-->
			<div class="col-sm-4 col-md-12">
				<!-- Javascript -->
				<script>
					init.push(function () {
						$("#stats-sparklines-2").pixelSparkline(
							[10,20,15,20,10], {
							type: 'bar',
							height: '36px',
							width: '100%',
							barSpacing: 2,
							zeroAxis: false,
							barColor: '#ffffff'
						});
					});
				</script>
				<!-- / Javascript -->

				<div class="stat-panel">
					<div class="stat-row">
						<!-- Warning background -->
						<div class="stat-cell bg-warning">
							<!-- Big text -->
							<span class="text-bg">11% more</span><br>
							<!-- Small text -->
							<span class="text-sm">Unique visitors today</span>
						</div>
					</div> <!-- /.stat-row -->
					<div class="stat-row">
						<!-- Warning background, small padding, without top padding, horizontally centered text -->
						<div class="stat-cell bg-warning padding-sm no-padding-t text-center">
							<div id="stats-sparklines-2" class="stats-sparklines" style="width: 100%"></div>
						</div>
					</div> <!-- /.stat-row -->
				</div> <!-- /.stat-panel -->
			</div>
		</div>
	</div>
</div>
<!-- /9. $UNIQUE_VISITORS_STAT_PANEL -->
